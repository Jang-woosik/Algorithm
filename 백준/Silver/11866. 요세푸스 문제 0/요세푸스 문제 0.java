import java.io.*;
import java.util.*;
//주어진 수를 최대로 정해서 list에 넣고 하나 없애고 앞으로 당기고 리스트 수보다 많아지면 맨 처음으로 돌아오도록
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int d=b-1;
		int count=1;
		ArrayList<Integer> c=new ArrayList<>();
		for(int i=1;i<a+1;i++) {
			c.add(i);
		}
		System.out.print("<");
		while(true) {
			System.out.print(c.get(d));
			c.remove(d);
			d=b+d-count;
			if(c.size()==0) {
				System.out.print(">");
				break;
			}
			System.out.print(", ");
			if(d>=c.size()) {
				d=d%c.size();
			}
			
		}
		
	}
}