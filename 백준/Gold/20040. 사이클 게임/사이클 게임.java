import java.io.*;
import java.util.*;

public class Main {

	
	static int[] parent;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		parent=new int[n];
		
		int cnt=0;
		
		
		for(int i=0;i<n;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<m;i++) {
			
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			if(ispossible(a, b)) {
				cnt++;
				if(cnt==m) {
					System.out.println("0");
				}
			}else {
				System.out.println(cnt+1);
				break;

			}
		}
		
	}
	
	static int find(int x) {
		if(parent[x]==x)return x;
		return parent[x]=find(parent[x]);
	}
	
	static boolean ispossible(int x, int y) {
		int nx=find(x);
		int ny=find(y);
		if(nx!=ny) {
			parent[nx]=ny;
			return true;
		}
		
		return false;
	}
}
