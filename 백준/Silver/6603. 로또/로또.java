import java.io.*;
import java.util.*;


/*
 * depth가 6이 되면 return
 * start와 depth를 통해서 재귀함수 생성
 * 
 */


public class Main {

	
	static int[]arr;
	static int[] lotto;
	static int k;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			k=Integer.parseInt(st.nextToken());
			
			arr=new int[k];
			lotto=new int[6];
			
			for(int i=0;i<k;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			
			if(k==0) {
				break;
			}
			
			group(0,0);
			System.out.println();
			
			
		}
		
	}
	
	public static void group(int start, int depth) {
		if(depth==6) {
			for(int i=0;i<6;i++) {
				System.out.print(lotto[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<k;i++) {
			lotto[depth]=arr[i];
			group(i+1,depth+1);
		}
		
	}
	
}