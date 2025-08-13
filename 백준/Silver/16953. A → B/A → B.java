import java.io.*;
import java.util.*;


/*
 * bfs를 활용해서 2를 곱하고 1을 옆에 추가하고 하는 모든 경우를
 * 큐에 넣어서 일치하면 return 일치하지 않으면 -1을 출력 
 */


public class Main {


	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long A=Long.parseLong(st.nextToken());
		long B=Long.parseLong(st.nextToken());
		
		int a=bfs(A,B);
		System.out.println(a);
	}
	static int bfs(long start, long fin) {
		Queue<long[]>q=new ArrayDeque<>();
		
		q.add(new long[] {start,1});
		
		while(!q.isEmpty()) {
			long[]current=q.poll();
			
			long num=current[0];
			long depth=current[1];
			
			if(num==fin) {
				return (int)depth;
			}
			
			long next=num*2;
			if(next<=fin) {
				q.add(new long[] {next,depth+1});
			}
			
			long next1=num*10+1;
			if(next1<=fin) {
				q.add(new long[] {next1,depth+1});
			}
			
		}
		return -1;
	}
	
}