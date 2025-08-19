import java.io.*;
import java.util.*;


/*
 * 
 * 
 */


public class Main {


	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[]arr=new int[N];
		int[]origin=new int[N];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			origin[i]=arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		

		HashMap<Integer,Integer>map=new HashMap<>();
		
		int rank=0;

			for(int value:arr) {
				if(!map.containsKey(value)) {
					map.put(value,rank);
					rank++;
				}
			}

		StringBuilder sb=new StringBuilder();
		for(int key:origin) {
			sb.append(map.get(key)).append(' ');
		}
		System.out.println(sb);
		
	}
}
