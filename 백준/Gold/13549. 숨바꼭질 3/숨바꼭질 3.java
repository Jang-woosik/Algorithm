import java.io.*;
import java.util.*;

/*
 * 
 * 
 */



public class Main {

	static class Node implements Comparable<Node>{
		int start,depth;
		public Node(int start,int depth) {
			this.start=start;
			this.depth=depth;
		}
		public int compareTo(Node o) {
			return this.depth-o.depth;
		}
	}
	public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	int N=Integer.parseInt(st.nextToken());
    	int K=Integer.parseInt(st.nextToken());
    	boolean[]visit=new boolean[100001];
    	
    	PriorityQueue<Node>q=new PriorityQueue<>();
    	q.add(new Node(N,0));
    	int total=0;
    	while(!q.isEmpty()) {
    		Node node=q.poll();
    		int x=node.start;
    		int y=node.depth;
    		visit[x]=true;
    		if(x==K) {
    			total=y;
    			break;
    		}
    		if(x*2>=0&&x*2<100001&&!visit[x*2]) {
    			
    			q.add(new Node(x*2,y));
    		}
    		if(x+1>=0&&x+1<100001&&!visit[x+1]) {
    			q.add(new Node(x+1,y+1));
    		}
    		if(x-1>=0&&x-1<100001&&!visit[x-1]) {
    			q.add(new Node(x-1,y+1));
    		}
    		
    	}
    	System.out.println(total);
    	
	}
	
}