import java.io.*;
import java.util.*;

/*
 * 2칸 올라가면 그냥 올라가는거고
 * 3칸 올라가는 경우는 이전에 연속칸 이미 오른거
 * 
 */

public class Main {
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int a=Integer.parseInt(br.readLine());
	    int[]map=new int[a+1];
	    int[]dp=new int[a+1];
	    for(int i=1;i<=a;i++) {
	    	
	    	map[i]=Integer.parseInt(br.readLine());
	    }
	    
	    dp[1]=map[1];
	    
	    if(a>=2) {
	    	dp[2]=map[1]+map[2];
	    }
	    
	    for(int i=3;i<=a;i++) {
	    	dp[i]=Math.max(dp[i-2], dp[i-3]+map[i-1])+map[i];
	    }
	    System.out.println(dp[a]);
	}
}