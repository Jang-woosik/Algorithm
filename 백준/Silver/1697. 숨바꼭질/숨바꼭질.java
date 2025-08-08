import java.io.*;
import java.util.*;


/*
 * 
 * Queue에 넣고 n-1 n+1 2*n 일때 계산해서 각각 큐에 다 집어넣고 
 * 각각 또 꺼내서 큐에 또 넣고 반복하다 보면 제일 먼저 도착하는 큐가 있을거다
 * 이를 내보내면 됨
 * 
 */


public class Main {
	
	static int N;
	static int K;
	static int[] visit=new int[100001];
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		int result=bfs(N);
		System.out.println(result);
	}
	
	public static int bfs(int node) {
		
		Queue<Integer>arr=new LinkedList<Integer>();
		arr.add(node);
		
		visit[node]=1;
		while(arr.isEmpty()==false) {
			
			
			int result=arr.remove();
	
			if(result==K) {
				return visit[result]-1;
			}if(result-1>=0&&visit[result-1]==0) {
				visit[result-1]=visit[result]+1;
				arr.add(result-1);
			}if(result+1<=100000&&visit[result+1]==0) {
				visit[result+1]=visit[result]+1;
				arr.add(result+1);
			}if(result*2<=100000&&visit[result*2]==0) {
				visit[result*2]=visit[result]+1;
				arr.add(result*2);
			}
			
			
		}
		
		
	return -1;	
	}
	
	
	
}
