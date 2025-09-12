import java.io.*;
import java.util.*;



public class Main {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    int r=Integer.parseInt(st.nextToken());
	    
	    int[]map=new int[n+1];
	    st=new StringTokenizer(br.readLine());
	    for(int i=1;i<=n;i++) {
	    	map[i]=Integer.parseInt(st.nextToken());
	    }
	    int[][]dist=new int[n+1][n+1];
	    for (int i = 1; i <= n; i++) {
	        for (int j = 1; j <= n; j++) {
	            dist[i][j] = 999999;
	        }
	    }
	    for(int i=1;i<=r;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int a=Integer.parseInt(st.nextToken());
	    	int b=Integer.parseInt(st.nextToken());
	    	int c=Integer.parseInt(st.nextToken());
	    	dist[a][b] = Math.min(dist[a][b], c);
	        dist[b][a] = Math.min(dist[b][a], c);
	    }
	    for(int k=1;k<n+1;k++) {
		    for(int i=1;i<n+1;i++) {
		    	for(int j=1;j<n+1;j++) {
		    		if(dist[i][j]>dist[i][k]+dist[k][j]) {
		    			dist[i][j]=dist[i][k]+dist[k][j];
		    		}
		    	}
		    }
	    }
	    int max=0;
	    for(int i=1;i<=n;i++) {
	    	int sum=0;
	    	for(int j=1;j<=n;j++) {
	    		if(i==j) {
	    			sum+=map[i];
	    		}else {
	    			if(dist[i][j]<=m) {
	    				sum+=map[j];
	    			}
	    		}
	    	}
	    	if(max<sum) {
	    		max=sum;
	    	}
	    }
	    System.out.println(max);
	}
}
