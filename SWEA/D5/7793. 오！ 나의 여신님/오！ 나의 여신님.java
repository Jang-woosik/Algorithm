import java.io.*;
import java.util.*;

/*
 * 처음 입력 받을때 목적지를 저장해두고 출발지도 저장
 * 먼저 악의 손아귀를 퍼뜨리고 마주치면 -1 리턴
 * 안 마주치고 잘 반환하면 값 내보내기
 */

public class Solution {
	static int[][]map;
    static int N,M;
    static boolean[][]visit;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T=Integer.parseInt(br.readLine());
	    
	    for(int s=1;s<T+1;s++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
		    N=Integer.parseInt(st.nextToken());
		    M=Integer.parseInt(st.nextToken());
		    map=new int[N][M];
		    int startx=0, starty=0;//여신위치
		    int finx=0, finy=0;//수연이 위치

		    visit=new boolean[N][M];
		    for(int i=0;i<N;i++) {
		    	String a=new String(br.readLine());
		    	for(int j=0;j<M;j++) {
		    		map[i][j]=a.charAt(j);
		    		if(map[i][j]=='S') {
		    			startx=i;
		    			starty=j;
		    		}else if(map[i][j]=='D') {
		    			finx=i;
		    			finy=j;
		    		}
		    	}
		    }
		    int result = bfs(startx, starty, finx, finy);
		    if(result == -1) {
		        System.out.println("#"+s+" "+"GAME OVER");
		    } else {
		        System.out.println("#"+s+" "+result);
		    }
	    }
	}
	static int bfs(int startx,int starty,int finx,int finy) {
		int[]dx= {1,-1,0,0};
		int[]dy= {0,0,1,-1};
		visit[startx][starty]=true;
		Queue<int[]>q=new ArrayDeque<>();
		Queue<int[]>q2=new ArrayDeque<>();
		q.add(new int[] {startx,starty,0});
		for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            if (map[i][j] == '*') {
	                q2.add(new int[]{i, j});
	            }
	        }
	    }
		while(!q.isEmpty()) {
			int a=q2.size();
			for(int j=0;j<a;j++) {
			int[]node2=q2.poll();
			for(int i=0;i<4;i++) {
				int nx=dx[i]+node2[0];
				int ny=dy[i]+node2[1];
				if(nx>=0&&ny>=0&&nx<N&&ny<M) {
					if(map[nx][ny]=='.'||map[nx][ny]=='S') {
					map[nx][ny]='*';
					q2.add(new int[] {nx,ny});
					}
				}
			}
			}
			int b=q.size();
			for(int j=0;j<b;j++) {
			int[]node=q.poll();
			
			if(node[0]==finx&&node[1]==finy) {
				return node[2];
			}
			for(int i=0;i<4;i++) {	
				int nx=dx[i]+node[0];
				int ny=dy[i]+node[1];
				int depth=node[2];
				if(nx>=0&&ny>=0&&nx<N&&ny<M&&!visit[nx][ny]) {
					if(map[nx][ny]=='.'||map[nx][ny]=='D') {
					visit[nx][ny]=true;
					q.add(new int[] {nx,ny,depth+1});
					}
				}
			}
			}
		}
		
		
		return -1;
	}
}
