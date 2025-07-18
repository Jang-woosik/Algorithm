
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(br.readLine());
		int count=0;
		for(int i=1;i<=a;i++) {
			int b=0;
			int c=0;
			int d=0;
			if(i>=1&&i<100) {
				count++;
			}else {
				b=i/100;
				c=(i%100)/10;
				d=i%10;
				if(b-c==c-d) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
