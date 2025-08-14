import java.io.*;
import java.util.*;


/*
 *M에 도달했을때 return
 *dfs가 한번 돌때마다 배열에 값을 넣어줌
 *return할때 출력하도록
 *첫 시작은 1부터 시작해서 count는 0부터
 */


public class Main {

	static int N,M;
	static int[] combination;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		combination=new int[M];
		
		dfs(1,0);
		
	}
	
	static void dfs(int start,int count) {
		if(count==M) {
			for(int i=0;i<combination.length;i++) {
				System.out.print(combination[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<N+1;i++) {
			combination[count]=i;
			dfs(i+1,count+1);

		}
		
	}
}