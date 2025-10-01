import java.io.*;
import java.util.*;


public class Main {
	
	static int m,n;
	static long cnt=0;
	static int[]map;
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());

	    st=new StringTokenizer(br.readLine());
	    map=new int[n];
	    
	    for(int i=0;i<n;i++) {
	    	map[i]=Integer.parseInt(st.nextToken());
	    }
	    dfs(0,0);
	    
	    if(m==0) {
	    	System.out.println(cnt-1);
	    }else {
	    	System.out.println(cnt);
	    }
	}

	private static void dfs(int idx,int sum) {
		if(idx==n) {
			if(sum==m) 	cnt++;
			return;
		}
		
		dfs(idx+1,sum+map[idx]);
		
		dfs(idx+1,sum);
	}
	
}
