/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int[][] grid = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case<=T; test_case++){
            for(int str = 0; str<9; str++){
                String[] input_line = br.readLine().split(" ");
                for(int inside = 0; inside<9; inside++){
                    grid[str][inside]=Integer.parseInt(input_line[inside]);
                }
            }
            
            bw.write("#"+test_case+" "+check());
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    static int check(){
        for(int i = 0; i<9; i++){
            boolean[] inside_visited = new boolean[10];
            boolean[] outside_visited = new boolean[10];
            for(int j = 0; j<9; j++){
                if(inside_visited[grid[i][j]]){
                    return 0;
                }
                inside_visited[grid[i][j]] = true;
                if(outside_visited[grid[j][i]]){
                    return 0;
                }
                outside_visited[grid[j][i]] = true;
            }
        }
        for (int i=0; i<9; i+=3){
            for(int j = 0; j<9; j+=3){
                boolean[] gridCheck = new boolean[10];
                for(int gy=i; gy<i+3; gy++){
                    for(int gx=j; gx<j+3; gx++){
                        if(gridCheck[grid[gy][gx]]){
                            return 0;
                        }
                        gridCheck[grid[gy][gx]]=true;
                    }
                }
            }
        }
        return 1;
    }
}