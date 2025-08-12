import java.io.*;
import java.util.*;


/*
 * 맥주를 집에서 20개 들고 나감
 * 집에서 들고 나가서 bfs로 큐에 넣어서 
 * 집에서 편의점까지 최소일때 좌표값 저장
 * 편의점에서 다음 편의점까지 최소일때 좌표값 저장
 * 그 최소일때 20캔이면 충분한지 확인
 * 
 */

class Point{
	int x;
	int y;
	
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
}


public class Main {
	static Point[] point;
	static int finx,finy;
	static boolean[]visit;
	static int n, startx, starty;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int m=0;m<T;m++) {
			n=Integer.parseInt(br.readLine());
			point=new Point[n+2];
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			startx=Integer.parseInt(st.nextToken());
			starty=Integer.parseInt(st.nextToken());
					
			
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				point[i]=new Point(a,b);
			}
			
			st=new StringTokenizer(br.readLine());
			
			finx=Integer.parseInt(st.nextToken());
			finy=Integer.parseInt(st.nextToken());

			if(bfs()) {
				System.out.println("happy");
				
			}else if(!bfs()) {
				System.out.println("sad");
			}
		}
	}
	
	static boolean bfs() {
		Queue<int[]>q=new LinkedList<>();
		q.offer(new int[] {startx,starty});
		visit=new boolean[n];
		
		while(!q.isEmpty()) {
			int[]p=q.poll();
			int nowX=p[0];
			int nowY=p[1];
			
			long fes=Math.abs(finx-nowX)+Math.abs(finy-nowY);
			
			if(fes<=1000) {
				return true;
			}
			
			for(int i=0;i<n;i++) {
				long store=Math.abs(point[i].x-nowX)+Math.abs(point[i].y-nowY);
				
				if(!visit[i]&&store<=1000) {
					q.offer(new int[] {point[i].x,point[i].y});
					visit[i]=true;
				}
			}
			
		}
		return false;
		
	}
	
}