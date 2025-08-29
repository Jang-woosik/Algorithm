import java.io.*;
import java.util.*;

/*
 * 처음 주어진 배열에서 해당 수 / 5해서 퍼트리고 가능한 방향 cnt해서
 * cnt곱하기 해당수/5한 값만큼 빼줘서 새로 저장
 * 새로운 배열에 새로운 값 저장
 * 이렇게 다 저장해두면 공청기랑 같은 row에 있으면 쭉 밀고 위로 올리고
 * 한바퀴돌리는데 공청기 아래랑 같으면 쭉 밀고 아래로 민다
 */

public class Main {
    

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int r = Integer.parseInt(st.nextToken());
	    int c = Integer.parseInt(st.nextToken());
	    int t = Integer.parseInt(st.nextToken());
	    int[] dx = {0, 1, 0, -1};
	    int[] dy = {-1, 0, 1, 0};

	    int[][] map = new int[r][c];//진짜 값 저장
	    int[][] map2 = new int[r][c];//일시적으로 저장해둘 공간
	    int[] x = new int[2];
	    int[] y = new int[2];
	    int cnt = 0;
	    for (int i = 0; i < r; i++) {
	        st = new StringTokenizer(br.readLine());
	        for (int j = 0; j < c; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	            map2[i][j] = map[i][j];
	            if (map[i][j] == -1) {
	                x[cnt] = i;
	                y[cnt] = j;
	                cnt++;
	            }
	        }
	    }
	    
	    for (int s = 0; s < t; s++) {
	        // map에서 5이상이면 주변으로 퍼뜨리게끔, -1이랑 범위를 벗어나면 제외
	        for (int i = 0; i < r; i++) {
	            for (int j = 0; j < c; j++) {
	                if (map[i][j] >= 5) {
	                    int cnt2 = 0;
	                    for (int k = 0; k < 4; k++) {
	                        int nx = i + dy[k]; 
	                        int ny = j + dx[k]; 
	                        if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] != -1) {
	                            map2[nx][ny] += (map[i][j]) / 5;
	                            cnt2++;
	                        }
	                    }
	                    map2[i][j] -= ((map[i][j]) / 5) * cnt2;
	                }
	            }
	        }
	        
	        for (int i = 0; i < r; i++) {
	            for (int j = 0; j < c; j++) {
	                map[i][j] = map2[i][j];
	            }
	        }
	        
	        // --- 위쪽 공기 순환 ---
	        for (int i = c - 1; i >= 0; i--) {//왼쪽
	            if (i - 1 >= 0) {
	                map2[0][i - 1] = map[0][i];
	            }
	        }
	        for (int i = 0; i < x[0]; i++) {//아래
	            if (map[i + 1][0] != -1) {
	                map2[i + 1][0] = map[i][0];
	            }
	        }
	        for (int i = 0; i < c; i++) {//오른
	            if (map[x[0]][i] == -1 && i + 1 < c) {
	                map2[x[0]][i + 1] = 0;
	            } else if (i + 1 < c && map[x[0]][i + 1] != -1) {
	                map2[x[0]][i + 1] = map[x[0]][i];
	            }
	        }
	        for (int i = 1; i <= x[0]; i++) {//위 (r-1 -> c-1 로 인덱스 수정)
	            if(i-1 >=0) {
	                map2[x[0] - i][c - 1] = map[x[0] - i + 1][c - 1];
	            }
	        }

	        // --- 아래쪽 공기 순환 ---
	        for(int i=0; i<c; i++) { // 오른쪽
	            if(map[x[1]][i] == -1 && i+1 < c) {
	                map2[x[1]][i+1] = 0; 
	            } else if (i+1 < c) {
	                map2[x[1]][i+1] = map[x[1]][i];
	            }
	        }
	        for(int i=x[1]; i<r-1; i++) { // 아래
	            map2[i+1][c-1] = map[i][c-1];
	        }
	        for(int i=c-1; i>0; i--) { // 왼쪽
	            map2[r-1][i-1] = map[r-1][i];
	        }
	        for(int i=r-1; i>x[1]; i--) { // 위
	            if (map[i-1][0] != -1) {
	                map2[i-1][0] = map[i][0];
	            }
	        }
	        
	        for(int i=0;i<r;i++) {
		    	for(int j=0;j<c;j++) {
		    		map[i][j]=map2[i][j];
		    	}    
	        }
	    
	    }
	    int total=0;
	    for(int i=0;i<r;i++) {
	    	for(int j=0;j<c;j++) {
	    		if(map[i][j]>-1) {
	    			total+=map[i][j];
	    		}
	    	}
	    }
	    System.out.println(total);
	}
}
