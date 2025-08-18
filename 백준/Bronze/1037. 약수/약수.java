import java.io.*;
import java.util.*;

/*
* 약수 모음들을 배열에 넣고 N이 홀수면 가운데값 넣고
* 짝수면 수 크기대로 배열해서 맨 앞이랑 맨 뒤랑 곱하기
*/
class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		int[]arr=new int[num];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<num;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		if(num%2==0){
			System.out.println(arr[0]*arr[num-1]);	
		}else{
			System.out.println(arr[num/2]*arr[num/2]);
		}
	}

}