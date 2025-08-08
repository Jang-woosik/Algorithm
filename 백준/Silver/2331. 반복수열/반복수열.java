import java.io.*;
import java.util.*;


/*
 * 
 * 이미 나온수가 또 나오면 그때 정지시키면 된다.
 * contains를 쓰면 됨
 * 
 */


public class Main {
	
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int A=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr=new ArrayList<>();
		
		arr.add(A);
		
		while(true) {
			int temp=arr.get(arr.size()-1);
			int result=0;
			while(temp!=0) {
				result+=(int) Math.pow(temp%10, (double)P);
				temp=temp/10;
			}
			
			if(arr.contains(result)) {
				int ans=arr.indexOf(result);
				System.out.println(ans);
				break;
			}
			
			arr.add(result);
		}
		
		
		
	}
	
}
