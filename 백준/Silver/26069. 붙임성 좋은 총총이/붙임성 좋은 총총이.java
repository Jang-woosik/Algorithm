import java.io.*;
import java.util.*;


/*
 * 오른쪽이나 왼쪽에 ChongChong이 있으면 둘다 hashset에 넣어줌
 * 마지막엔 hashset개수 세기
 * 
 */


public class Main {
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));		
		
		int N=Integer.parseInt(br.readLine());
		
		HashSet<String>map=new HashSet<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			String A=st.nextToken();
			String B=st.nextToken();
			
			if(A.equals("ChongChong")||B.equals("ChongChong")) {
				map.add(A);
				map.add(B);
			}else if(map.contains(A)||map.contains(B)) {
				map.add(A);
				map.add(B);
				
			}
			
		}
		System.out.println(map.size());
	}
	
}
