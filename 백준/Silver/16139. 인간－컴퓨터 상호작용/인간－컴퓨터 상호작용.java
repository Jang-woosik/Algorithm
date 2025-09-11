import java.io.*;
import java.util.*;

/*
 * 
 */

public class Main {

	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String s=br.readLine();
	    
	    int q=Integer.parseInt(br.readLine());
	    int[][] sum=new int[26][s.length()];
	    sum[s.charAt(0)-'a'][0] = 1;
	    
	    for(int j=1;j<s.length();j++) {
	   		for(int i=0;i<26;i++) {
	   			sum[i][j]=sum[i][j-1];
	   		}
	   		sum[s.charAt(j)-'a'][j]++;
	   	}
	    StringBuilder sb=new StringBuilder();
	    for(int i=0;i<q;i++) {
	    	StringTokenizer st=new StringTokenizer(br.readLine());
		    
		    int a=st.nextToken().charAt(0)-'a';
		    int l=Integer.parseInt(st.nextToken());
		    int r=Integer.parseInt(st.nextToken());
		    
		    if(l==0) {
		    	sb.append(sum[a][r]).append("\n");
		    }else {
		    	sb.append(sum[a][r]-sum[a][l-1]).append("\n");
		    }
		    
	    }
	    System.out.println(sb.toString());
	}
	
}
