import java.util.*;
import java.io.*;


/*
 * 
 * 한번 방문한 곳은 다시 방문 안하니까 2개 입력 받을때 
 * x좌표, y좌표 바꿔서 넣어주고
 * 숫자 sort
 * 
 */


public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int[] order;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 정점 번호가 작은 순서부터 방문하도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }

    static void dfs(int node) {
        visit[node] = true;
        order[node] = cnt++;

        for (int next : graph[node]) {
            if (!visit[next]) {
                dfs(next);
            }
        }
    }
}
