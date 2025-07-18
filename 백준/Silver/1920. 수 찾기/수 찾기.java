
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(br.readLine());
		HashSet<Integer> b=new HashSet<>();
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<a;i++) {	
			b.add(Integer.parseInt(st.nextToken()));
		}
		
		int c=Integer.parseInt(br.readLine());
		
		StringTokenizer st1=new StringTokenizer(br.readLine());
	
		for(int i=0;i<c;i++) {
			int d=Integer.parseInt(st1.nextToken());
			int count=0;
			for(int j=0;j<b.size();j++) {
				if(b.contains(d)) {
					System.out.println("1");
					break;
				}else if(!b.contains(d)) {
					System.out.println("0");
					break;
				}
			}
		}
	}
}
