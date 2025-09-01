import java.io.*;
import java.util.*;

/*
 * 4x4 배열에서 dfs로 반복시키면 될듯
 */

public class Solution {

    static int[][] map;
    
    static HashSet<String> uniqueNumbers;
    
    static int[] dx = {0, 0, 1, -1}; // 상, 하, 우, 좌
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            map = new int[4][4];
            
            uniqueNumbers = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, 1, String.valueOf(map[i][j]));
                }
            }

            
            System.out.println("#" + test_case + " " + uniqueNumbers.size());
        }
    }

    static void dfs(int x, int y, int count, String currentNumStr) {
        
        if (count == 7) {
            
            uniqueNumbers.add(currentNumStr);
            
            return;
        }

        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            
            if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4) {
                
                dfs(nx, ny, count + 1, currentNumStr + map[nx][ny]);
            }
        }
    }
}
