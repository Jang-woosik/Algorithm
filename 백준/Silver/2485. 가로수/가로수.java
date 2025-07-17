
import java.util.*;
import java.io.*;

public class Main {
	public static int gcd(int a,int b) {
		if(a%b==0) {
			return b;
		}return gcd(b,a%b);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(br.readLine());
		ArrayList<Integer> b=new ArrayList<>();
		ArrayList<Integer> d=new ArrayList<>();
		
		for(int i=0;i<a;i++) {
			int c=Integer.parseInt(br.readLine());
			b.add(c);
		}
		for(int i=0;i<a-1;i++) {
			d.add(b.get(i+1)-b.get(i));
		}
		int e = d.get(0);
		for (int i = 1; i < d.size(); i++) {
			e = gcd(e, d.get(i));
		}
		int f=(b.get(b.size()-1)-b.get(0))/e-(a-1);
		System.out.println(f);
	}
}