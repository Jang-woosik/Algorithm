import java.io.*;
import java.util.*;


/*
 *1로 0을 변화시키고
 *마지막에 0이 남아있으면 그때 -1출력
 *arr2를 arr랑 같이 만들어서 변화는 arr2에 넣기
 *그러고 하루가 지나면 arr2 덮어씌우기
 *
 *
 */


public class Main {

	static int[][]arr;
	static int M,N;
	static Queue<int[]>q=new LinkedList<>();
	static int day;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) { // 큐에 초기 익은 토마토 추가
                    q.add(new int[]{i, j, 0});
                }
			}
		}
		bfs();
		if(check()) {
			System.out.println(day);
		}else {
			System.out.println("-1");
		}
		
		
		
	}
	
	static void bfs() {
		int[]dx= {1,-1,0,0};
		int[]dy= {0,0,1,-1};

		day=0;
		
		while(!q.isEmpty()) {
			int[]tomato=q.poll();
			int x=tomato[0];
			int y=tomato[1];
			day=tomato[2];
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M && arr[nx][ny] == 0) {
		            arr[nx][ny] = 1; 
		            q.add(new int[]{nx, ny, day + 1});
		        }
			}
			
			
		}
		
	}
	static boolean check() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0)
				return false;
			}
		}
		return true;
	}
	
}