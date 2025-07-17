
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		for(int i=a;i<=b;i++) {
			int count=0;
			if(i==1||i==2) {
				System.out.println("2");
				i=2;
			}
			else {
				for(int j=2;j*j<=i*2;j++) {
					if(i%j==0) {
						count++;
						break;
					}
				}

				if(count==0) {
					System.out.println(i);
				}
			}			
		}
	}
}