import java.io.*;
import java.util.*;

/*
 * 교차로 사이에 있는 도로 통과해야함
 * 시작점에서 교차로 두개중에 하나 먼저 가고
 * 교차로 하나에서 남은 하나로 이동
 * 교차로에서 우선순위로 가까운거부터
 * 마지막 목적지랑 겹치면 return
 * 목적지가 여러개라서 배열에 넣고 하나하나 
 * cost total로 저장해서 min이랑 같으면 정답 배열에 넣기
 * min보다 크면 저장 안하고 작으면 이전 배열 날리고 새로
 */

public class Main {
	
	static class Node implements Comparable<Node>{
		int to, cost;
		public Node(int to,int cost) {
			this.to=to;
			this.cost=cost;
		}public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	static int[]result;
	static int n;
	static ArrayList<Node>[]list;
	public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T=Integer.parseInt(br.readLine());
    	for(int v=1;v<T+1;v++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		
    		n=Integer.parseInt(st.nextToken());
    		int m=Integer.parseInt(st.nextToken());
    		int t=Integer.parseInt(st.nextToken());
    		list=new ArrayList[n+1];
    		int[]arr=new int[t];//목적지 배열
    		ArrayList<Integer>ans=new ArrayList<>();
    		for(int i=1;i<n+1;i++) {
    			list[i]=new ArrayList<>();//arraylist 초기화
    		}
    		
    		st=new StringTokenizer(br.readLine());
    		
    		int s=Integer.parseInt(st.nextToken());
    		int g=Integer.parseInt(st.nextToken());
    		int h=Integer.parseInt(st.nextToken());
    		
    		for(int i=0;i<m;i++) {
    			st=new StringTokenizer(br.readLine());
        		
        		int a=Integer.parseInt(st.nextToken());
        		int b=Integer.parseInt(st.nextToken());
        		int d=Integer.parseInt(st.nextToken());
        		list[a].add(new Node(b,d));
        		list[b].add(new Node(a,d));
    		}
    		for(int i=0;i<t;i++) {
    			arr[i]=Integer.parseInt(br.readLine());
    		}
    		int min=100_000_000;
    		for(int i=0;i<t;i++) {
    			
    			int sum=dik(s,g)+dik(g,h)+dik(h,arr[i]);
    			int sum2=dik(s,h)+dik(h,g)+dik(g,arr[i]);
    			int sum3=dik(s,arr[i]);
    			if(sum3>=Math.min(sum2, sum)) {
    				ans.add(arr[i]);
    			}
    		}

    		Collections.sort(ans);
    		for(int i=0;i<ans.size();i++) {
    			System.out.print(ans.get(i)+" ");
    		}
    		System.out.println();
    	}
	}
	static int dik(int start, int end) {
		PriorityQueue<Node>q=new PriorityQueue<>();
		result=new int[n+1];
		Arrays.fill(result, 100_000_000);
		boolean[] visit=new boolean[n+1];
		q.add(new Node(start,0));
		result[start]=0;
		while(!q.isEmpty()) {
			Node now=q.poll();
			visit[now.to]=true;
			
			for(int i=0;i<list[now.to].size();i++) {
				Node next=list[now.to].get(i);
				if(!visit[next.to]&&now.cost+next.cost<result[next.to]) {
					result[next.to]=now.cost+next.cost;
					q.add(new Node(next.to, result[next.to]));
				}
			}
		}
		return result[end];
	}
}