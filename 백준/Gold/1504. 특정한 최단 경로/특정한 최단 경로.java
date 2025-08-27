import java.io.*;
import java.util.*;

/*
 * 정점에서 다른 정점까지 거리
 * 거리가 최단 길이가 되도록
 * 앞에가 가지고 있는 사이즈만큼 for문 돌리기
 * 우선순위 큐로 거리 정렬을 시키고 꼭 가야되는 두 곳을 1에서 어디가 최소인지 찾고 
 * 그 점으로 부터 나머지 한개 최소 거리도 찾고 그로부터 최종까지 최소
 * 1부터 v1이나 v2까지 그로부터 N까지
 */



public class Main {

	static class Node implements Comparable<Node>{
		int to,cost;
		public Node(int to, int cost) {
			this.to=to;
			this.cost=cost;
		}
		public int compareTo(Node o){
			return this.cost-o.cost;
		}
	}
	
	static boolean[]visit;
	static ArrayList<Node>[]list;
   	static int[]result;
	static int v1,v2,N;
   	static int INF=200000000;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	int E=Integer.parseInt(st.nextToken());
    	result=new int[N+1];
    	list=new ArrayList[N+1];
    	
    	for(int i=1;i<N+1;i++) {
    		list[i]=new ArrayList<>();
    	}
    	
    	for(int i=0;i<E;i++) {
    		st=new StringTokenizer(br.readLine());
    		int a=Integer.parseInt(st.nextToken());
    		int b=Integer.parseInt(st.nextToken());
    		int c=Integer.parseInt(st.nextToken());
    		list[a].add(new Node(b,c));
    		list[b].add(new Node(a,c));
    	}
    	st=new StringTokenizer(br.readLine());
    	v1=Integer.parseInt(st.nextToken());
    	v2=Integer.parseInt(st.nextToken());
    	int res1=dik(1,v1)+dik(v1,v2)+dik(v2,N);
    	int res2=dik(1,v2)+dik(v2,v1)+dik(v1,N);
    	if(res1>=INF&&res2>=INF) {
    		System.out.println("-1");
    	}else {
    		System.out.println(Math.min(res1, res2));
    	}
    	
    }
    static int dik(int start,int end) {
    	result=new int[N+1];
    	PriorityQueue<Node>q=new PriorityQueue<>();
    	visit=new boolean[N+1];
    	Arrays.fill(result, INF);
    	
    	q.add(new Node(start,0));
    	result[start]=0;
    	
    	while(!q.isEmpty()){
    		Node now=q.poll();
    		if(!visit[now.to]) {
    			visit[now.to]=true;
    		
    		for(Node next:list[now.to]) {
    			if(!visit[next.to]&&now.cost+next.cost<result[next.to]) {
    				result[next.to]=now.cost+next.cost;
    				q.add(new Node(next.to,result[next.to]));
    			}
    			
    		}
    		}
    	}
    	return result[end];
    }
}