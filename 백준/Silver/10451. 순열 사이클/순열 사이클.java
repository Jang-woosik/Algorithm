import java.io.*;
import java.util.*;


/*
 * 수가 두 줄로 입력을 받아올때
 * 첫줄 수와 연결된 두번째 수 가 있을때
 * abcde
 * bcdea
 * 이러면 a->b->c->d->e->a로 이어지는 순열이 연결
 * 
 * 
 */


public class Main {
	
	static boolean[]visit;
	static int N;
	static int []arr;
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int as=0;as<T;as++) {
			N=Integer.parseInt(br.readLine());
			arr=new int[N+1];
			visit=new boolean[N+1];
			int cnt=0;
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=1;i<N+1;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=1;i<N+1;i++) {
				if(!visit[i]) {
					group(i);
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		
		
	}
	
	static void group(int node) {
		
		visit[node]=true;
		node=arr[node];
		
			if(!visit[node]) {
				group(node);
			}	
	}
	
}
