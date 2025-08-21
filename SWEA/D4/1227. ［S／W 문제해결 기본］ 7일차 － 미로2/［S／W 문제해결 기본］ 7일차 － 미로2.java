import java.io.*;
import java.util.*;

/*
 * 방문한데 방문 다시 안하게
 * 상하좌우로 퍼져나가게
 * 2부터 시작
 * 
 */


public class Solution { 
	
	static int[][]arr;
	static boolean[][] visit;
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       for(int s=0;s<10;s++) {
    	   int T=Integer.parseInt(br.readLine());
    	   arr=new int[100][100];
    	   int x1=0,y1=0,x2=0,y2=0;
    	   visit=new boolean[100][100];
    	   
    	   for(int i=0;i<100;i++) {
    		   String st=br.readLine();
    		   for(int j=0;j<100;j++) {
    			   arr[i][j]=st.charAt(j)-'0';
    			   if(arr[i][j]==2) {
    				   x1=i;
    				   y1=j;
    			   }else if(arr[i][j]==3) {
    				   x2=i;
    				   y2=j;
    			   }
    		   }
    	   }
    	   System.out.println("#"+T+" "+bfs(x1,y1,x2,y2));
       }
      
       
    }
    
    public static int bfs(int start1,int start2,int fin1,int fin2) {
    	Queue<int[]>q=new ArrayDeque<>();
    	
    	int[]dx= {1,-1,0,0};
    	int[]dy= {0,0,1,-1};
    	visit[start1][start2]=true;
    	q.add(new int[] {start1,start2});
    	
    	while(!q.isEmpty()) {
    		int[]v=q.poll();
    		int x=v[0];
    		int y=v[1];
    		if(x==fin1&&y==fin2) {
    			return 1;
    		}
    		for(int i=0;i<4;i++) {
    			int nx=x+dx[i];
    			int ny=y+dy[i];
    			if(nx>=0&&ny>=0&&nx<100&&ny<100&&!visit[nx][ny]) {
    				if(arr[nx][ny]==0||arr[nx][ny]==3) {
    				q.add(new int[] {nx,ny});
    				visit[nx][ny]=true;
    				}
    			}
    		}
    	}
    	return 0;
    }
    
    
}