import java.io.*;
import java.util.*;

/*
 * 미생물 위치가 r,c가 0이거나 최댓값보다 1작을때 반으로 줄어든다
 * 그리고 이때 이동방향도 반대로 상하면 상하로만 좌우면 좌우로만 변경
 * 두 군집이 하나로 합치기 위해서 union으로 합치고
 * 뭐가 더 큰지 그에 맞는 이동방향으로 바꾸기
 */


public class Solution { 
	
	static class Node{
		int num, rot;
		public Node(int num, int rot) {
			
			this.num=num;
			this.rot=rot;
		}
	}
	
	static int total, N;
	static ArrayList<Node>[][]map;
	static ArrayList<Node>[][]map2;
	
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T=Integer.parseInt(br.readLine());
      for(int s=1;s<T+1;s++) {
    	  StringTokenizer st=new StringTokenizer(br.readLine());
    	  
    	  N=Integer.parseInt(st.nextToken());
    	  int M=Integer.parseInt(st.nextToken());
    	  int K=Integer.parseInt(st.nextToken());
    	  map=new ArrayList[N][N];
    	  map2=new ArrayList[N][N];
    	  
    	  for(int i=0;i<N;i++) {
    		  for(int j=0;j<N;j++) {
    			  map[i][j]=new ArrayList<>();
    			  map2[i][j]=new ArrayList<>();
    		  }
    	  }
    	  
    	  total=0;
    	  for(int i=0;i<K;i++) {
    		  st=new StringTokenizer(br.readLine());
        	  
    		  int a=Integer.parseInt(st.nextToken());
    		  int b=Integer.parseInt(st.nextToken());
    		  int c=Integer.parseInt(st.nextToken());
    		  int d=Integer.parseInt(st.nextToken());
    		  
    		  map[a][b].add(new Node(c,d));
    	  }
    	  
    	  for(int i=0;i<M;i++) {
    		  for(int j=0;j<N;j++) {
    			  for(int k=0;k<N;k++) {
    				 if(!map[j][k].isEmpty()) {
    					 graph(j,k);
    				 }
    			  }
    		  }
    		  for(int j=0;j<N;j++) {
    			  for(int k=0;k<N;k++) {
    				  map[j][k].clear();
    			  	}
    			  }
    		  
    		  for(int j=0;j<N;j++) {
    			  for(int k=0;k<N;k++) {
    				  
    				  if(map2[j][k].size()>=1) {
    					  int maxNum=0;
        				  int maxRot=0;
        				  int sumNum=0;
        				  for(Node node: map2[j][k]) {
        					  sumNum+=node.num;
        					  if(node.num>maxNum) {
        						  maxNum=node.num;
        						  maxRot=node.rot;
        					  }
        				  }
        				  if(sumNum>0) {
        					  map[j][k].add(new Node(sumNum,maxRot));
        				  }
    			  }
    				  map2[j][k].clear();
    		  }
    		  }
    	  }
    		  int sum=0;
    		  for(int i=0;i<N;i++) {
    			  for(int j=0;j<N;j++) {
    			  if(!map[i][j].isEmpty()) {
    				  Node node=map[i][j].get(0);
    				  sum+=node.num;

    			  	}
    			  }
    			  
    		  }
    		  System.out.println("#"+s+" "+sum);
      }
      
    }
    
    static void graph(int x, int y) {
    	int[]dx= {-1,1,0,0};
    	int[]dy= {0,0,-1,1};
    	Node node=map[x][y].get(0);
    	int nx=x+dx[node.rot-1];
    	int ny=y+dy[node.rot-1];
    	
    	//이동
    	if(nx>0&&nx<N-1&&ny>0&&ny<N-1) {
    		map2[nx][ny].add(new Node(node.num,node.rot));
    	}
    	
    	//N-1이나 0이 되면 방향 바꾸고 군집 수 반으로 줄이기
    	else {
    		int newNum=node.num/2;
    		int newRot=0;
    		if(node.rot==1) {
    			newRot=2;
    		}else if(node.rot==2) {
    			newRot=1;
    		}else if(node.rot==3) {
    			newRot=4;
    		}else if(node.rot==4) {
    			newRot=3;
    		}
    		if(newNum>0) {
    			map2[nx][ny].add(new Node(newNum,newRot));
    		}
    	}
    	

    }
    
}