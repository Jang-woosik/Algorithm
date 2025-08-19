import java.io.*;
import java.util.*;


/*
 * 1,2,3일때 1만열림
 * 4,5,6,7,8일때 1,4만 열림
 */


public class Main {

	
	public static void main(String[] args)throws IOException{
				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int count=(int)Math.sqrt(N);
				
		System.out.println(count);
	}
	
}
