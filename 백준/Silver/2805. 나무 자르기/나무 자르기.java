import java.util.*;
import java.io.*;


/*
 * 
 * 일단 제일 큰 나무보다 톱날이 크면 잘리는게 없으니
 * 제일 큰 나무를 톰날 길이로 설정하고 1씩 줄이는게 방법
 * 그래서 음수는 나오면 안되니 톱날 길이보다 큰 나무만 sum에 더하도록
 * 그냥 코딩하면 시간 초과 뜨니까
 * mid를 설정해서 이와 비교해서 이진 탐색
 * 
 * 
 */

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int[]arr=new int[a];
		int c=0;
		int max=0;
		
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<a;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		
		int left=0;
		int right=max;
		int result=0;
		
		while(left<=right) {
			int mid=(left+right)/2;
			long sum=0;
			
			for(int i=0;i<a;i++) {
				if(arr[i]>mid) {
					sum+=(arr[i]-mid);
				}
			}
			if(sum>=b) {
				result=mid;
				left=mid+1;
			}else {
				right=mid-1;
			}
			
			
			
		}
		System.out.println(result);
		
		
	}
}
