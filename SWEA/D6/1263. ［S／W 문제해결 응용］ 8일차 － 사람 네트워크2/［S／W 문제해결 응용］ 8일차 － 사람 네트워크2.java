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
        	
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	int n=Integer.parseInt(st.nextToken());
        	int[][]map=new int[n+1][n+1];
        	for(int i=1;i<=n;i++) {
        		for(int j=1;j<=n;j++) {
        			map[i][j]=Integer.parseInt(st.nextToken());
        			if(i==j) {
        				map[i][i]=0;
        			}else if(map[i][j]==0) {
        				map[i][j]=999999;
        			}
        		}
        	}
        	for(int k=1;k<=n;k++) {
        		for(int i=1;i<=n;i++) {
        			for(int j=1;j<=n;j++) {
        				if(map[i][j]>map[i][k]+map[k][j]) {
        					map[i][j]=map[i][k]+map[k][j];
        					
        				}
        			}
        		}
        	}

        	int min=Integer.MAX_VALUE;
        	for(int i=1;i<=n;i++) {
        		int sum=0;
        		for(int j=1;j<=n;j++) {
        			sum+=map[i][j];
        		}
        		if(sum<min) {
    				min=sum;
    			}
        	}
        	System.out.println("#"+s+" "+min);
        }

    }
}
