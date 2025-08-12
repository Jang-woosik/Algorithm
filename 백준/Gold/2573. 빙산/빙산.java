import java.io.*;
import java.util.*;


/*
 * 
 * 빙산 전체 입력받아서 빙산 주변에 0인걸 찾아내고
 * 빙산 덩어리가 몇개인지 세기
 * 2개 이상 덩어리 생기면 정지
 * 각 빙산들 0보다 크면 1씩 줄여나가기
 * 빙산 덩어리가 몇개인지 세기->dfs
 * 주변에 0이 몇개인지 찾아서 이거만큼 뺴줘야 빙산 높이 수정 가능
 * 
 */


public class Main {
	
	static int[][]arr;
	static boolean[][]visit;
	static int N,M;
	static int[][]me;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt2=0;
		
		
		
		while(true) {
			visit=new boolean[N][M];
			int cnt=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!visit[i][j]&&arr[i][j]!=0) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			
			if(cnt>=2) {
				System.out.println(cnt2);
				break;
			}if(cnt==0) {
				System.out.println("0");
				break;
			}
			
			
			melt();
			cnt2++;
			
		}
		
	}
	
	static void dfs(int x, int y) {
		int[]dx= {1,-1,0,0};
		int[]dy= {0,0,1,-1};
		visit[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0&&ny>=0&&nx<N&&ny<M&&!visit[nx][ny]&&arr[nx][ny]!=0) {
				dfs(nx,ny);
				
			}
		}
		
	}
	static void melt() {
		int[]dx= {1,-1,0,0};
		int[]dy= {0,0,1,-1};
		me=new int[N][M];	
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if (arr[i][j] > 0) {
				for(int k=0;k<4;k++) {
					int nx=i+dx[k];
					int ny=j+dy[k];
					if(nx>=0&&ny>=0&&nx<N&&ny<M&&arr[nx][ny]==0) {
						me[i][j]+=1;
					}
				}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j]-=me[i][j];
				if(arr[i][j] < 0) {
                    arr[i][j] = 0;
                }
			}
		}
		
		
	}
}