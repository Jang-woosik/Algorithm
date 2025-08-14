import java.io.*;
import java.util.*;

/*
 * 
 * N이 2가 되도록 만들기
 * 제곱근이든 1을 더해서든 만들기
 * 우선 제곱근은 정수일때만 가능하니
 * 정수일때 값과 double일때 값이 같을때
 * 그 경우에만 제곱근이 가능한것으로 설정
 *
 * 
 */

class Solution {

	static long num;
	
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int i=1;i<T+1;i++) {
        	long N=Long.parseLong(br.readLine());
        	
        	num=0;
        	
        	while(N!=2) {
        		double p=Math.sqrt(N);
        		if((long)p==p) {
        			num++;
        			N=(long)p;
        		}
                //1을 하나씩 더하면 런타임에러 한번에 다음 제곱근 가능 수를 찾는 방법
                else {
        			long a=(long)(Math.sqrt(N)+1);
        			long b=(a*a);
        			
        			num+=(b-N);
        			N=b;
        			
        		}
        	}
        	System.out.println("#"+i+" "+num);
        }    
   }
    
}
