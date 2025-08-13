import java.io.*;
import java.util.*;


/*
 *swea 1952
 */


public class Solution {

	static int answer;
	static int []arr;
	static int m1,m2,m3,m4;
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int a=0;a<T;a++) {
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			m1=Integer.parseInt(st.nextToken());
			m2=Integer.parseInt(st.nextToken());
			m3=Integer.parseInt(st.nextToken());
			m4=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			
			arr=new int[12];
			
			for(int i=0;i<12;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			answer=m4;
			dfs(0,0);
			System.out.println("#"+(a+1)+" "+answer);
			
		}
	
	}
	
	
	
	public static void dfs(int month, int cost) {
		//12월을 넘으면 return, answer에 사용
		if(month>=12) {
			answer=Math.min(cost, answer);
			return;
		}
		
		//1일과 1달 이용권은 같이 따져줌 이용일 없으면 1일 이용권이 0되니까 상관없음
		int min=Math.min(arr[month]*m1, m2);
		dfs(month+1,min+cost);
		//3달 이용권이므로 3달 뒤로 이동
		dfs(month+3,cost+m3);
	}
	
}