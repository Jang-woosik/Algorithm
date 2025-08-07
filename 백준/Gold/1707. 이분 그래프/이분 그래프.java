import java.io.*;
import java.util.*;


/*
 * 
 * 2 3 3 4를 입력받아서 2 4가 연결됐는데
 * 다음에 4 2가 들어오면 이분 그래프가 안됨 
 * 이걸 활용해서 풀면 되지않
 * 
 */


public class Main {
	
	static int[] visit;
	static ArrayList<Integer>[] al;
	static int V,E;
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			
			visit=new int[V+1];
			al=new ArrayList[V+1];
			
			for(int j=0;j<=V;j++) {
				al[j]=new ArrayList<Integer>();
			}
			
			for(int j=0;j<E;j++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				al[a].add(b);
				al[b].add(a);
			}
				
			group();	
			
		}
		
	}
	
	
	public static void group() {
		Queue<Integer> q=new LinkedList<Integer>();
		
		for(int i=1;i<=V;i++) {
			if(visit[i]==0) {
				q.add(i);
				visit[i]=1;
			}
			while(!q.isEmpty()) {
				int now=q.poll();
				for(int j=0;j<al[now].size();j++) {
					if(visit[al[now].get(j)]==0) {
						q.add(al[now].get(j));
					}
					if(visit[al[now].get(j)]==visit[now]) {
						System.out.println("NO");
						return;
					}
					if(visit[now]==1&&visit[al[now].get(j)]==0) {
						visit[al[now].get(j)]=2;
					}
					else if(visit[now]==2&&visit[al[now].get(j)]==0) {
						visit[al[now].get(j)]=1;
					}
				}
			}
		}
		System.out.println("YES");
	}
	
	
}
