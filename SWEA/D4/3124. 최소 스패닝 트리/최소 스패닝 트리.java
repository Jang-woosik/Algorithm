import java.io.*;
import java.util.*;

/*
 * 1에서 방문할 곳 큐에 넣고 2에서 방문할곳 큐에 넣고
 * 우선순위 큐이기때문에 계속 반복하면 최소거리가 구해짐
 * 방문 안 한곳만 계속 반복시키면 됨
 */


public class Solution { 
	
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
	
	static ArrayList<Node>[]list;
	static int[]result;
	static int[]parent;
	static boolean[]visit;
	static long total;
	static int V;;
	
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T=Integer.parseInt(br.readLine());
     for(int s=1;s<T+1;s++) {
    	 StringTokenizer st=new StringTokenizer(br.readLine());
         V=Integer.parseInt(st.nextToken());
         int E=Integer.parseInt(st.nextToken());
         list=new ArrayList[V+1];
         result=new int[V+1];
         parent=new int[V+1];
         visit=new boolean[V+1];
         
         for(int i=1;i<V+1;i++) {
       	  list[i]=new ArrayList<>();
       	  result[i]=Integer.MAX_VALUE;
         }
         for(int i=0;i<E;i++) {
       	  st=new StringTokenizer(br.readLine());
       	  int a=Integer.parseInt(st.nextToken());
       	  int b=Integer.parseInt(st.nextToken());
       	  int c=Integer.parseInt(st.nextToken());
       	  list[a].add(new Node(b,c));
       	  list[b].add(new Node(a,c));
         }
         for(int i=1;i<V+1;i++) {
       	  parent[i]=i;
         }

         System.out.println("#"+s+" "+dik(V));
     }
    }
    static long dik(int end) {
    	PriorityQueue<Node>q=new PriorityQueue<>();
    	
    	q.add(new Node(1,0));
    	int cnt=0;
    	total=0;
    	
    	while(!q.isEmpty()) {
    		Node now=q.poll();
    		if(!visit[now.to]) {
    			cnt++;
    			visit[now.to]=true;
    			total+=now.cost;
    			for(int i=0;i<list[now.to].size();i++) {
    				q.add(list[now.to].get(i));
    			}
    		}
    		if(cnt==end) {
    			break;
    		}
    	}
    	return total;
    }
}