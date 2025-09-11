import java.io.*;
import java.util.*;

/*
 * 
 */

public class Main {

	static int[][]map;
	static StringBuilder sb=new StringBuilder();
	static int[]sum;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	    int n=Integer.parseInt(br.readLine());
	    
	    map=new int[n][n];
	    sum=new int[3];
	    for(int i=0;i<n;i++) {
	    	StringTokenizer st=new StringTokenizer(br.readLine());
	    	for(int j=0;j<n;j++) {
	    		map[i][j]=Integer.parseInt(st.nextToken());
	    	}
	    }
	    paper(0,0,n);
	    System.out.println(sum[0]);
	    System.out.println(sum[1]);
	    System.out.println(sum[2]);
	}
	static void paper(int x,int y,int size) {
		if(isPossible(x,y,size)) {
			sum[map[x][y]+1]++;
			return;
		}
		size=size/3;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				paper(x+size*i,y+size*j,size);
			}
		}
	}
	static boolean isPossible(int x,int y,int size) {
		int def=map[x][y];
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(def!=map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
