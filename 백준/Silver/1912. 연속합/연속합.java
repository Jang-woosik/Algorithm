import java.io.*;
import java.util.*;


/*
 * 맨 처음 수만 dp배열에 저장해두고
 * 이를 max로 설정한뒤에
 * 이를 재귀적으로 접근해서 그때그때 최대를 찾음
 */


public class Main {
	
	static int max;
	static Integer[]dp;
	static int[]arr;
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		dp=new Integer[N];
		arr=new int[N];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		dp[0]=arr[0];
		max=arr[0];
		test(N-1);
		System.out.println(max);
	}
	public static int test(int node) {
		
		if(dp[node]==null) {
			dp[node]=Math.max(test(node-1)+arr[node], arr[node]);
			
			max=Math.max(dp[node], max);
		}
		
		return dp[node];
	}
}
