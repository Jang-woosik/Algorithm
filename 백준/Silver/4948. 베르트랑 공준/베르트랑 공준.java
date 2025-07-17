
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int a=Integer.parseInt(br.readLine());
			int sum=0;
			if(a==1) {
				System.out.println("1");
				continue;
			}
			else if(a==2) {
				System.out.println("1");
				continue;
			}
			else if(a==0) {
				break;
			}
			else {
				for(int i=a+1;i<=2*a;i++) {
					int count=0;
					
					for(int j=2;j*j<=i;j++) {
						if(i%j==0) {
							count++;
							break;
						}
						
					}
					if(count==0) {
						sum++;
					}
					
				}
			}
			System.out.println(sum);
		}
	}
}