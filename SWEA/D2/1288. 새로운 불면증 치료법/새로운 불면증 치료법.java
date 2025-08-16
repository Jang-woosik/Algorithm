import java.io.*;
import java.util.*;


public class Solution {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int m=1;m<T+1;m++) {
		
			int N=Integer.parseInt(br.readLine());
			
			int[]arr=new int[10];
			
			int x=1;

			while(true) {
				
				int a=(x*N);
				
				while(true) {
					arr[a%10]=1;
					a=a/10;
					if(a==0) {
						break;
					}
				}
				
				int b=0;
				for(int i=0;i<10;i++) {
					if(arr[i]!=0) {
						b++;
					}
				}
				if(b==10) {
					System.out.println("#"+m+" "+(x*N));
					break;
				}
				
				x++;
			}
			
		}
	}
}
