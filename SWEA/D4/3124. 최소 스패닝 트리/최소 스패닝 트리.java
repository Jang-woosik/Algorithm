import java.io.*;
import java.util.*;

/*
 * 각 점에서 다른 점까지 가는데 거리 측정
 * 사이클이 생기면 최소 비용이 아니기때문에 union-find사용
 * 최소 비용이 언제인지부터 찾아서 시작
 */


public class Solution { 
	
	static class Test implements Comparable<Test>{
		int from,to,m;
		public Test(int from, int to, int m) {
			this.from=from;
			this.to=to;
			this.m=m;
		}
		
		public int compareTo(Test t) {
			return this.m-t.m;
		}
		
	}
	
	
	static int[] parent;
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int t=Integer.parseInt(br.readLine());
       
       for(int s=1;s<t+1;s++) {
    	   StringTokenizer st=new StringTokenizer(br.readLine());
    	   int V=Integer.parseInt(st.nextToken());
    	   int E=Integer.parseInt(st.nextToken());
    	   parent=new int[V+1];
    	   
    	   for(int i=1;i<V+1;i++) {
    		   parent[i]=i;
    	   }
    	   PriorityQueue<Test>q=new PriorityQueue<>();
    	   
    	   for(int i=0;i<E;i++) {
    		   st=new StringTokenizer(br.readLine());
    		   int from=Integer.parseInt(st.nextToken());
    		   int to=Integer.parseInt(st.nextToken());
    		   int cost=Integer.parseInt(st.nextToken());
    		   q.add(new Test(from,to,cost));
    	   }
    	   
    	   long ans=0;
    	   int cost=0;
    	   while(!q.isEmpty()) {
    		   Test test=q.poll();
    		   if(!union(test.from,test.to)) {
    			   continue;
    		   }
    		   ans+=test.m;
    		   if(++cost==V-1) {
    			   break;
    		   }
    	   }
    	   System.out.println("#"+s+" "+ans);
       }
       
	}
    
    
    
    static int find(int x) {
    	if(parent[x]==x)return x;
    	return parent[x]=find(parent[x]);
    }
    static boolean union(int x, int y) {
    	int pa=find(x);
    	int pi=find(y);
    	if(pa!=pi) {
    		parent[pi]=pa;
    		return true;
    	}
    	return false;
    }
    
}