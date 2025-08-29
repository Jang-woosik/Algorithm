import java.io.*;
import java.util.*;

/*
 * 거리를 다 측정하고 출발지랑 목적지랑 다를때 
 * i,j를 바꿔서 둘다 max가 아니면 수를 더해서 min에 저장
 * 이거보다 작은거나오면 min 변경
 * 
 */

public class Main {
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        
        int[][]map=new int[V+1][V+1];
        
        for(int i=1;i<V+1;i++) {
    		for(int j=1;j<V+1;j++) {
    			if(i==j) {
    				map[i][j]=0;
    			}else {
    				map[i][j]=Integer.MAX_VALUE;
    			}
    		}
    	}
        
        for(int i=0;i<E;i++) {
        	st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            map[a][b]=c;
        }
        for(int k=1;k<V+1;k++) {
        	for(int i=1;i<V+1;i++) {
        		for(int j=1;j<V+1;j++) {
        			if(map[i][k]!=Integer.MAX_VALUE&&map[k][j]!=Integer.MAX_VALUE) {
        				map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
        			}
        		}
        	}
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<V+1;i++) {
        	for(int j=i+1;j<V+1;j++) {
        		if(i!=j&&map[i][j]!=Integer.MAX_VALUE&&map[j][i]!=Integer.MAX_VALUE) {
        			if(min>map[i][j]+map[j][i]) {
        				min=map[i][j]+map[j][i];
        			}
        		}
        	}
        }
        if(min==Integer.MAX_VALUE) {
        	System.out.println("-1");
        }else {
        	System.out.println(min);
        }
    }
}