import java.io.*;
import java.util.*;

/*
 * 일단 그래프 형태로 연결시키고
 * 주어진 점을 기준으로 뻗어나갈수있는게 있는지 확인하고
 * 여기에 깊이를 넣어준다
 * 깊이가 1씩 커질때마다 깊이 저장해두고
 * 그 깊이들 중에서도 가장 큰 값을 저장한다
 * 그리고 깊이가 커지면 값을 다시 저장하고
 * 연결을 어떻게 시킬것인지
 * 큐에서 하나씩 꺼내서 퍼지게 
 */


public class Solution { 
	
	static int min,min2;
    static ArrayList<Integer>[]arr;
	static boolean[]visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int s=1;s<11;s++) {
        	StringTokenizer st=new StringTokenizer(br.readLine());
            min=-1;
            min2=-1;
            int N=Integer.parseInt(st.nextToken());
            int node=Integer.parseInt(st.nextToken());
            arr=new ArrayList[101];
            for(int i=0;i<101;i++) {
           		arr[i]=new ArrayList<Integer>();
            }
            
            visit=new boolean[101];
            
            st=new StringTokenizer(br.readLine());
            
            for(int i=0;i<N/2;i++) {
            	int a=Integer.parseInt(st.nextToken());
            	int b=Integer.parseInt(st.nextToken());
            	
            	arr[a].add(b);
            	
            }
            bfs(node,0);
            System.out.println("#"+s+" "+min2);
        }
    }
    
    public static void bfs(int node,int depth) {
    	Queue<int[]>q=new ArrayDeque<>();
    	q.add(new int[] {node,depth});  	
    	
    	while(!q.isEmpty()) {
    		int[]v=q.poll();
    		node=v[0];
    		depth=v[1];

    		if(depth>min) {
        		min=depth;
        		min2=node;
        		
        	}else if(depth==min) {
        		if(node>min2) {
        			min2=node;
        		}
        	}
	
    		
    		for(int i=0;i<arr[node].size();i++) {
        		if(!visit[arr[node].get(i)]) {
        			q.add(new int[] {arr[node].get(i),depth+1});
            		visit[arr[node].get(i)]=true;
        		}
    		}
    		
    		
    	}
    }
    
}