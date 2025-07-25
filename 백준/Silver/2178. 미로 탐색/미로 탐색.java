import java.util.*;
import java.io.*;

public class Main {
	static int [][] map;
	static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
       map=new int[N][M];
        
        for(int i=0;i<N;i++) {
        	String st1=br.readLine();
        	for(int j=0;j<M;j++) {
        		map[i][j]=st1.charAt(j)-'0';
        	}
        }
        bfs(0,0);
        
        //시작점도(0,0) 이니까 도착점도 [N-1][M-1]
        System.out.println(map[N-1][M-1]);
        
    }
    static void bfs(int x,int y) {
    	boolean[][]visit=new boolean[N][M];
    	
    	//q에 x,y좌료 한번에 저장하기 위해서 int[]상태로 선언
    	Queue<int[]>q=new LinkedList<>();
    	
    	//q에 시작점 저장
    	q.add(new int[] {x,y});
    	
    	//시작점은 true로 변경하고 시작
    	visit[x][y]=true;
    	int[]dx= {1,-1,0,0};
    	int[]dy= {0,0,1,-1};
    	
    	
    	while(!q.isEmpty()) {
        	int[] current=q.poll();
        	
        	//q에 넣어둔 x,y좌표 각각 current에 저장
        	int cx=current[0];
        	int cy=current[1];

        	for(int i=0;i<4;i++) {
        		int nx=cx+dx[i];
        		int ny=cy+dy[i];
        		if(nx>=0&&ny>=0&&nx<N&&ny<M&&map[nx][ny]==1&&!visit[nx][ny]) {
        			
        			//이동량 1씩 증가해서 저장
        			map[nx][ny]=map[cx][cy]+1;
        			
        			//방문했으니 상태 변경
        			visit[nx][ny]=true;
        			
        			//가야할 경로가 남았으면  add해서 while문 다시 작동
        			q.add(new int[]{nx,ny});
        		}
        	}
    	}
    	
    }
    	
    	
    	
   
}
