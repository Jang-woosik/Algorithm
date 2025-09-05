import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int a = Integer.parseInt(br.readLine());
	    
	    
	    int[] dp = new int[a + 1];
	    
	    
	    for (int i = 2; i <= a; i++) {
	    
	    	dp[i] = dp[i-1] + 1;
	        
	        // 2로 나누어 떨어지는 경우
	        if (i % 2 == 0) {
	            dp[i] = Math.min(dp[i], dp[i/2] + 1);
	        }
	        
	        // 3으로 나누어 떨어지는 경우
	        if (i % 3 == 0) {
	            dp[i] = Math.min(dp[i], dp[i/3] + 1);
	        }
	    }
	    
	    System.out.println(dp[a]);
	}
}