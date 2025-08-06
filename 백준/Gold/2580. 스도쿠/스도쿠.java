import java.util.*;
import java.io.*;


/*
 * 
 * 우선 0대신 넣을 수가 세로줄이나 가로줄에 있는지
 * boolean으로 검사해서 true면 넣도록
 * 
 */

public class Main {
	
	static int[][] arr=new int[9][9];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		
		for(int i=0;i<9;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		sudo(0,0);
		
		
	}
	
	public static void sudo(int row, int col) {
		if(col==9) {
			sudo(row+1,0);
			return;
		}
		
		if(row==9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		if(arr[row][col]==0) {
			for(int i=1;i<=9;i++) {
				if((possibility(row,col,i))) {
					arr[row][col]=i;
					sudo(row,col+1);
				}
			}
			arr[row][col]=0;
			return;
		}
		
		sudo(row,col+1);
	}
	
	
	
	public static boolean possibility(int row, int col, int value) {
		
		for(int i=0;i<9;i++) {
			if(arr[i][col]==value) {
				return false;
			}
		}
		
		for(int i=0;i<9;i++) {
			if(arr[row][i]==value) {
				return false;
			}
		}
		
		int set_row=(row/3)*3;
		int set_col=(col/3)*3;
		
		for(int i=set_row;i<set_row+3;i++) {
			for(int j=set_col;j<set_col+3;j++) {
				if(arr[i][j]==value) {
					return false;
				}
			}
		}
		return true;
		
		
	}
	
	
}
