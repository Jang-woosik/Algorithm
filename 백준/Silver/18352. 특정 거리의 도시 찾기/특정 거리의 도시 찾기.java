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
		}
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	static ArrayList<Node>[]list;
	static int n,k;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    k=Integer.parseInt(st.nextToken());
	    int x=Integer.parseInt(st.nextToken());
	    list=new ArrayList[n+1];
	    for(int i=1;i<=n;i++) {
	    	list[i]=new ArrayList<>();
	    }
	    for(int i=0;i<m;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int a=Integer.parseInt(st.nextToken());
	    	int b=Integer.parseInt(st.nextToken());
	    	list[a].add(new Node(b,1));
	    	
	    }
	    sb=new StringBuilder();
	    dik(x);
	    if(sb.length()==0) {
	    	System.out.println("-1");
	    }else {
	    	
	    	System.out.println(sb);
	    }
	}
	static void dik(int start) {
		
		PriorityQueue<Node>q=new PriorityQueue<>();
		q.add(new Node(start,0));
		int[]result=new int[n+1];
		boolean[]visit=new boolean[n+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[start]=0;
		while(!q.isEmpty()) {
			
			Node now=q.poll();
			if(visit[now.to]) {
				continue;
			}
			visit[now.to]=true;
			
			for(int i=0;i<list[now.to].size();i++) {
				Node next=list[now.to].get(i);
				if(!visit[next.to]&&next.cost+now.cost<result[next.to]) {
					result[next.to]=next.cost+now.cost;
					q.add(new Node(next.to,result[next.to]));
				}
			}
		}
		for(int i=1;i<=n;i++) {
			if(result[i]==k) {
				sb.append(i).append("\n");
			}
		}
	}
}
