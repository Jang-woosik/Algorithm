import java.io.*;

public class Main {

    // 배열을 static으로 선언하여 프로그램 전체에서 공유
    // 문제의 최대 범위(예: 1,000,001)로 한 번만 생성
    public static boolean[] isPrime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

     
        sieve();

        int T = Integer.parseInt(br.readLine());
        // 테스트 케이스 루프 시작
        for (int s = 0; s < T; s++) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;

            for (int i = 2; i <= N / 2; i++) {
                // isPrime 배열 사용
                if (isPrime[i] && isPrime[N - i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }


    static void sieve() {
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                // i의 '배수'들을 지워나감
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}