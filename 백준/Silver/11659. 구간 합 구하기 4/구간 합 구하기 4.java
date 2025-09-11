import java.io.*;
import java.util.*;

/*
 * 
 */

public class Main {

	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    int[]map=new int[n+1];
	    
	    st=new StringTokenizer(br.readLine());
	    
	    for(int i=1;i<n+1;i++) {
	    	map[i]=Integer.parseInt(st.nextToken());
	    }
	    
	    int[]sum=new int[n+1];
	    for(int i=1;i<=n;i++) {
	    	sum[i]=map[i]+sum[i-1];
	    }
	    
	    for(int i=0;i<m;i++) {
	    	st=new StringTokenizer(br.readLine());
		    int a=Integer.parseInt(st.nextToken());
		    int b=Integer.parseInt(st.nextToken());
		    
		    
		    System.out.println(sum[b]-sum[a-1]);
	    }
	    
	}
	
}
