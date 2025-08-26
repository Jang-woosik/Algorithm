import java.io.*;
import java.util.*;

/*
 * 각 점에서 다른 점까지 가는데 거리 측정
 * 사이클이 생기면 최소 비용이 아니기때문에 union-find사용
 * 최소 비용이 언제인지부터 찾아서 시작
 */


public class Solution { 
	
	static int[]parent;
	
	static class Test implements Comparable<Test>{
		int x,y;
		long m;
		public Test(int x, int y, long m) {
			this.x=x;
			this.y=y;
			this.m=m;
		}
		public int compareTo(Test t) {
			return Long.compare(this.m, t.m);
		}
	}
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T=Integer.parseInt(br.readLine());
       
       for(int s=1;s<T+1;s++) {
    	   
    	   int N=Integer.parseInt(br.readLine());
    	   long[]x=new long[N];
    	   long[]y=new long[N];
    	   
    	   StringTokenizer st=new StringTokenizer(br.readLine());
    	   for(int i=0;i<N;i++) {
    		   x[i]=Long.parseLong(st.nextToken());
    	   }
    	   st=new StringTokenizer(br.readLine());
    	   for(int i=0;i<N;i++) {
    		   y[i]=Long.parseLong(st.nextToken());
    	   }
    	   double E=Double.parseDouble(br.readLine());
    	   
    	   parent=new int[N];
    	   
    	   for(int i=0;i<N;i++) {
    		   parent[i]=i;
    	   }
    	   
    	   PriorityQueue<Test>q=new PriorityQueue<>();
    	   
    	   for(int i=0;i<N;i++) {
    		   for(int j=i+1;j<N;j++) {
    			   long L=(x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]);
    			   q.add(new Test(i,j,L));
    		   }
    	   }
    	   long cnt=0;
    	   long ans=0;
    	   while(!q.isEmpty()) {
    		   Test test=q.poll();
    		   if(union(test.x,test.y)) {
    			   continue;
    		   }
    		   ans+=test.m;
    		   if(++cnt==N-1) {
    			   break;
    		   }
    	   }
    	   System.out.println("#"+s+" "+Math.round(ans*E));
       }
       
    }
    
    //union-find
    static int find(int x) {
		if(parent[x]==x) {
			return x;
		}
		return parent[x]=find(parent[x]);
	}
	
	static boolean union(int x,int y) {
		int pi=find(x);
		int pj=find(y);
		if(pi!=pj) {
			parent[pj]=pi;
			return false;
		}
		return true;
	}
    
    
}