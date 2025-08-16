import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int m = 1; m <= 10; m++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			LinkedList<Integer> arr = new LinkedList<>();

            // 초기 암호문 리스트 생성
			for (int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}

			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				String b = st.nextToken();
				
				if (b.equals("I")) { // 삽입
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						arr.add(x + j, Integer.parseInt(st.nextToken()));
					}
				} else if (b.equals("D")) { // 삭제
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						arr.remove(x);
					}
				} else if (b.equals("A")) { // 추가
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						arr.add(Integer.parseInt(st.nextToken()));
					}
				}
			}

            // 결과 출력
			System.out.print("#" + m + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
		}
	}
}