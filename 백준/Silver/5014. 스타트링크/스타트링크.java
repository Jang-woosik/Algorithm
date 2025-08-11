import java.io.*;
import java.util.*;


/*
 * 
 * bfs를 활용해서 큐에 시작점을 넣어줌
 * 시작점에서 너비로 퍼져서
 * 각각의 경우에 타겟과 만나게 될때 리턴
 * 
 */


public class Main {
	
	static int U;
	static int D;
	static int F;
	static boolean[] visit;
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		F=Integer.parseInt(st.nextToken());// 건물 층수
		int S=Integer.parseInt(st.nextToken());// 현위치
		int G=Integer.parseInt(st.nextToken());// 가야할 곳
		U=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		visit=new boolean[F+1];
		
		int a=bfs(S,G);
		if(a==-1) {
			System.out.println("use the stairs");
			
		}else {
			System.out.println(a);
		}
		
	}
	
	public static int bfs(int start, int target) {
		 if (start == target) return 0;
		
		Queue<Integer>q=new ArrayDeque<>();
		int[] dis=new int[F+1];
		
		q.add(start);
		
		
		visit[start]=true;

		while(!q.isEmpty()) {
			int v=q.poll();
			
			if(v-D>=1&&!visit[v-D]) {
				visit[v-D]=true;
				dis[v-D]=dis[v]+1;
				if(v-D==target) {
					return dis[v-D];
				}
				q.add(v-D);
			}
			if(v+U<=F&&!visit[v+U]) {
				visit[v+U]=true;
				dis[v+U]=dis[v]+1;
				if(v+U==target) {
					return dis[v+U];
				}
				q.add(v+U);
			}
		}
		
		
		return -1;
	}
}