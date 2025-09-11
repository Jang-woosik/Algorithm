import java.io.*;
import java.util.*;

/*
 * 
 */

public class Main {
	
	public static class Node implements Comparable<Node>{
		int to,cost;
		public Node(int to,int cost) {
			this.to=to;
			this.cost=cost;
		}public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	
	static ArrayList<Node>[]list;
	static int n;
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    int x=Integer.parseInt(st.nextToken());
	    
	    list=new ArrayList[n+1];
	    for(int i=1;i<n+1;i++) {
	    	list[i]=new ArrayList<>();
	    }
	    
	    for(int i=0;i<m;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int a=Integer.parseInt(st.nextToken());
	    	int b=Integer.parseInt(st.nextToken());
	    	int c=Integer.parseInt(st.nextToken());
	    	list[a].add(new Node(b,c));
	    }
	    int max=0;
	    for(int i=1;i<=n;i++) {
	    	if(max<dik(i,x)+dik(x,i)) {
	    		max=dik(i,x)+dik(x,i);
	    	}
	    }
	    System.out.println(max);
	}
	static int dik(int start,int end) {
		PriorityQueue<Node>q=new PriorityQueue<>();
		q.add(new Node(start,0));
		boolean[]visit=new boolean[n+1];
		int[]result=new int[n+1];

		Arrays.fill(result, Integer.MAX_VALUE);
		result[start]=0;
		
		while(!q.isEmpty()) {
			Node now=q.poll();
			visit[now.to]=true;
			for(int i=0;i<list[now.to].size();i++) {
				Node next=list[now.to].get(i);
				if(!visit[next.to]&&now.cost+next.cost<result[next.to]) {
					result[next.to]=now.cost+next.cost;
					q.add(new Node(next.to,result[next.to]));
				}
			}
		}
		return result[end];
	}
}
