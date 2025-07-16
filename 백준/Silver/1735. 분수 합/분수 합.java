
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int sum1=0;
		int sum2=0;
		int sum3=1;
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		StringTokenizer st1=new StringTokenizer(br.readLine());
		int c=Integer.parseInt(st1.nextToken());
		int d=Integer.parseInt(st1.nextToken());
		sum2=d*b;
		sum1=a*d+c*b;
		for(int i=1;i<=Math.min(sum1,sum2);i++) {
			if(sum1%i==0&&sum2%i==0) {
				sum3=i;
			}
		}
		
		sum2=sum2/sum3;
		sum1=sum1/sum3;
		System.out.println(sum1+" "+sum2);
	}
}