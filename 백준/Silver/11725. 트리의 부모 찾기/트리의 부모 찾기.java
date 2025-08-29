import java.io.*;
import java.util.*;

/*
 * 서로 연결된거 확인되면 1 입력
 * 1부터 시작해서 얘랑 연결된게 있으면 큐에 넣고
 * 큐에서 계속 반복적으로 뽑아내기
 */

public class Main {
	
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N=Integer.parseInt(br.readLine());
	    ArrayList<Integer>[]map=new ArrayList[N+1];
	    for(int i=1;i<=N;i++) {
	    	map[i]=new ArrayList<>();
	    }
	    
	    int[]result=new int[N+1];
	    boolean[]visit=new boolean[N+1];
	    
	    for(int i=0;i<N-1;i++) {
	    	StringTokenizer st=new StringTokenizer(br.readLine());
	    	int a=Integer.parseInt(st.nextToken());
	    	int b=Integer.parseInt(st.nextToken());
	    	map[a].add(b);
	    	map[b].add(a);
	    }
	    Queue<Integer>q=new ArrayDeque<>();
	    q.add(1);
	    visit[1]=true;
	    while(!q.isEmpty()) {
	    	int start=q.poll();
	    	
	    	for(int i=0;i<map[start].size();i++) {
	    		if(!visit[map[start].get(i)]) {
	    			visit[start]=true;
	    			q.add(map[start].get(i));
	    			result[map[start].get(i)]=start;
	    		}
	    	}
	    }
	    for(int i=2;i<N+1;i++) {
	    	System.out.println(result[i]);
	    }
	    
	}
	
}
