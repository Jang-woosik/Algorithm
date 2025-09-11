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
	static ArrayList<Node>[]map;
	static int n;
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	    n=Integer.parseInt(br.readLine());
	    int m=Integer.parseInt(br.readLine());
	    map=new ArrayList[n+1];
	    for(int i=1;i<=n;i++) {
	    		map[i]=new ArrayList<>();
	    }
	    for(int i=0;i<m;i++) {
	    	StringTokenizer st=new StringTokenizer(br.readLine());
		    int a=Integer.parseInt(st.nextToken());
		    int b=Integer.parseInt(st.nextToken());
		    int c=Integer.parseInt(st.nextToken());
		    map[a].add(new Node(b,c));
	    }
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    int ex=Integer.parseInt(st.nextToken());
	    int ey=Integer.parseInt(st.nextToken());
	    System.out.println(dik(ex,ey));
	}
	
	static int dik(int start,int end) {
		PriorityQueue<Node>q=new PriorityQueue<>();
		int[]result=new int[n+1];
		q.add(new Node (start,0));
		Arrays.fill(result, Integer.MAX_VALUE);
		result[start]=0;
		while(!q.isEmpty()) {
			Node now=q.poll();
			if(now.cost>result[now.to]) {
				continue;
			}
			
			for(int i=0;i<map[now.to].size();i++) {
				Node next=map[now.to].get(i);
				if(now.cost+next.cost<result[next.to]) {
					result[next.to]=now.cost+next.cost;
					q.add(new Node(next.to,result[next.to]));
				}
			}
		}
		return result[end];
	}
	
}
