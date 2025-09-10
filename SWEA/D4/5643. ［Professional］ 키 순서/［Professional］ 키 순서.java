import java.io.*;
import java.util.*;

/*
 * 중간중간 들러서 거리 최솟값을 설정해줌
 * 이전에 설정된 값보다 큰지 작은지 비교해서
 * 만약에 크다면 새로운 수로 바꿔줌
 */

public class Solution {

	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T=Integer.parseInt(br.readLine());
        for(int s=1;s<=T;s++) {
        	
        	int n=Integer.parseInt(br.readLine());
        	int m=Integer.parseInt(br.readLine());
        	
        	boolean[][]map=new boolean[n+1][n+1];

        	
        	for(int i=1;i<=m;i++) {
        		StringTokenizer st=new StringTokenizer(br.readLine());
        		int a=Integer.parseInt(st.nextToken());
        		int b=Integer.parseInt(st.nextToken());
        		map[a][b]=true;
        	}
        	
        	
        	for(int k=1;k<=n;k++) {
        		for(int i=1;i<=n;i++) {
        			for(int j=1;j<=n;j++) {
        				if(map[i][k]&&map[k][j]) {
        					map[i][j]=true;
        					
        				}
        			}
        		}
        	}

        	int min=0;
        	for(int i=1;i<=n;i++) {
        		int sum=0;
        		for(int j=1;j<=n;j++) {
        			if(i==j) {
        				continue;
        			}
        			if(map[i][j]||map[j][i]) {
        				sum++;
        			}
        		}
        		if(sum==n-1) {
    				min++;
    			}
        	}
        	System.out.println("#"+s+" "+min);
        }

    }
}
