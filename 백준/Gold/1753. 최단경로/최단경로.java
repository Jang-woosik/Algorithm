import java.io.*;
import java.util.*;

public class Main {

   static class Node implements Comparable<Node>{
	   int to, cost;
	   public Node(int to, int cost) {
		   this.to=to;
		   this.cost=cost;
	   }
	   public int compareTo(Node o) {
		   return this.cost-o.cost;
	   }
   }

   	static boolean[]visit;
   	static int[]result;
   	static List<Node>[]list;
   	
    public static void main(String[] args) throws IOException {
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	int V=Integer.parseInt(st.nextToken());
    	int E=Integer.parseInt(st.nextToken());
    	
    	int K=Integer.parseInt(br.readLine());
    	list=new List[V+1];
    	visit=new boolean[V+1];
    	result=new int[V+1];
    	
    	for(int i=1;i<=V;i++) {
    		list[i]=new ArrayList<>();
    		result[i]=Integer.MAX_VALUE;
    	}
    	for(int i=0;i<E;i++) {
    		st=new StringTokenizer(br.readLine());
    		int u=Integer.parseInt(st.nextToken());
    		int v=Integer.parseInt(st.nextToken());
    		int w=Integer.parseInt(st.nextToken());
    		list[u].add(new Node(v,w));
    	}
    	dik(K);
    	for(int i=1;i<=V;i++) {
    		if(result[i]==Integer.MAX_VALUE) {
    			System.out.println("INF");
    		}else {
    			System.out.println(result[i]);
    		}
    	}
    }
    
    static void dik(int start) {
    	result[start]=0;
    	
    	PriorityQueue<Node>q=new PriorityQueue<>();
    	q.add(new Node(start, 0));
    	
    	while(!q.isEmpty()) {
    		Node now=q.poll();
    		if(!visit[now.to]) {
    			visit[now.to]=true;
    		}
    		
    		for(int i=0;i<list[now.to].size();i++) {
    			Node next=list[now.to].get(i);
    			if(!visit[next.to]&&now.cost+next.cost<result[next.to]) {
    				result[next.to]=now.cost+next.cost;
    				q.add(new Node(next.to,result[next.to]));
    			}
    		}
    	}
    	
    }
    
    
}