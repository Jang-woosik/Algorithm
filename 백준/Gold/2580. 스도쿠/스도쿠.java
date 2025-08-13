import java.io.*;
import java.util.*;


/*
 *백준 2580
 * 세로가로줄에 없고
 * 네모칸 내에도 없는 수를 넣어야한다
 * 가로세로에 있는 수들을 배열에 넣고
 * 
 */


public class Main {

	static int[][]arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		arr=new int[9][9];
		
		for(int i=0;i<9;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		if(sudo(0,0)) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}	
		}

	}
	
	static boolean possible(int num, int row, int col) {
		
		//가로줄
		for(int i=0;i<9;i++) {
			if(arr[row][i]==num) {
				return false;
			}
		}
		
		//세로줄
		for(int i=0;i<9;i++) {
			if(arr[i][col]==num) {
				return false;
			}
		}
		//사각형
		for(int i=(row/3)*3;i<(row/3)*3+3;i++) {
			for(int j=(col/3)*3;j<(col/3)*3+3;j++) {
				if(arr[i][j]==num) {
					return false;
				}
			}
		}
		return true;
	}
	
	static boolean sudo(int row, int col) {
		//가로줄이 9줄되면 완성이니까 true
		if(row==9) {
			return true;
		}
		
		// col이 8이면 한줄 완성이니까 다음 줄로
		int next_row=(col==8)?row+1:row;
		int next_col=(col+1)%9;
		
		//현재 0이 아니면 다음으로 넘어가기
		if(arr[row][col]!=0) {
			return sudo(next_row,next_col);
		}
		
		//현재 0일떄의 경우를 따져봄
		for(int num=1;num<10;num++) {
			if(possible(num,row,col)) {
				arr[row][col]=num;
				if(sudo(next_row,next_col)) {
					return true;
				}
				arr[row][col]=0;
			}

		}
		return false;
	}
	
}