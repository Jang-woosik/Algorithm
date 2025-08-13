import java.io.*;
import java.util.*;


/*
 * 1이 상하좌우에 있는 0을 1로 바꿔줌
 * -1로 둘러싸인 0이 있으면 -1을 출력
 * 1인 경우와 -1인 경우 나눠서 dfs반복
 * 전부 1이면 0출력
 * 
 * 
 * 
 */


public class Solution {

	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int s=0;s<T;s++) {
			int[][]arr=new int[9][9];
			boolean visit=false;
			
			for(int i=0;i<9;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<9;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//가로줄 확인
			for(int i=0;i<9;i++) {
				ArrayList<Integer>arr2=new ArrayList<>();
				for(int j=0;j<9;j++) {
					if(arr2.contains(arr[i][j])) {
						visit=true;
					}
					arr2.add(arr[i][j]);
				}
			}
			
			//세로줄 확인
			for(int i=0;i<9;i++) {
				ArrayList<Integer>arr2=new ArrayList<>();
				for(int j=0;j<9;j++) {
					if(arr2.contains(arr[j][i])) {
						visit=true;
					}
					arr2.add(arr[j][i]);
				}
			}
			
			
			
			//작은 사각형 확인
			for(int start=0;start<8;start+=3) {
				for(int fin=0;fin<8;fin+=3) {
					ArrayList<Integer>arr2=new ArrayList<>();
					for(int i=start;i<start+3;i++) {
						
					
						for(int j=fin;j<fin+3;j++) {
							if(arr2.contains(arr[i][j])) {	
								visit=true;
							}
							arr2.add(arr[i][j]);
						}
					}
				}	
			}
			if(visit) {
				System.out.println("#"+(s+1)+" 0");
			}else if(!visit) {
				System.out.println("#"+(s+1)+" 1");
			}
			
		}
		
	}
}