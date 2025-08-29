import java.io.*;
import java.util.*;

public class Main {
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        long[][]result=new long[n+1][n+1];
        
        for(int i=1;i<n+1;i++) {
        	for(int j=1;j<n+1;j++) {
        		if(i==j) {
        			result[i][j]=0;
        		}else {
        			result[i][j]=Long.MAX_VALUE;
        			}
        		}
        }
        
        for(int i=0;i<m;i++) {
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	int c=Integer.parseInt(st.nextToken());
        	result[a][b]=Math.min(result[a][b], c);
        }
        for(int k=1;k<n+1;k++) {
        	for(int i=1;i<n+1;i++) {
        		for(int j=1;j<n+1;j++) {
        			if(result[i][k]!=Long.MAX_VALUE&&result[k][j]!=Long.MAX_VALUE) {
        				result[i][j]=Math.min(result[i][j], result[i][k]+result[k][j]);
        			}
        		}
        	}
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<n+1;i++) {
        	for(int j=1;j<n+1;j++) {
                // 이 부분을 수정합니다.
        		if (result[i][j] == Long.MAX_VALUE) { // 경로가 없는 경우
                    sb.append("0 ");
                } else { // 경로가 있는 경우
                    sb.append(result[i][j] + " ");
                }
        	}
        	sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}