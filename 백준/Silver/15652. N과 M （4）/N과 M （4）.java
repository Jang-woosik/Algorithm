import java.util.*;
import java.io.*;


public class Main {
		
	static boolean[] visit;
	static StringBuilder sb=new StringBuilder();
	static int[] arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		visit=new boolean[a];
		arr=new int[b];
		
		dfs(a,b,0,0);
		System.out.println(sb);
	}
	public static void dfs(int a, int b, int depth,int start) {
		if(b==depth) {
			for(int i=0;i<b;i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i=start;i<a;i++) {
			
				
				arr[depth]=i+1;
				dfs(a,b,depth+1,start);
				start+=1;

		}
	}
}
