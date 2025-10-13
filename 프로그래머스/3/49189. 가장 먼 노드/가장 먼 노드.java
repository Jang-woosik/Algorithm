import java.util.*;

class Solution {
    // 전역 상태
    static List<Integer>[] adj;     // 인접 리스트 (메모리 절약)
    static int[] dist;              // 1번에서 각 노드까지 최단 거리
    static int N;

    public int solution(int n, int[][] edges) {
        N = n;

        // 인접 리스트 초기화
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        // 간선 입력 (양방향)
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        // 거리배열: 아주 큰 값으로 채워두고 시작점만 0
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dfs(1, 0); // DFS로 최단거리 갱신 (가지치기)

        // 가장 먼 거리와 그 개수 계산
        int max = 0;
        for (int i = 1; i <= N; i++) if (dist[i] < Integer.MAX_VALUE / 2) max = Math.max(max, dist[i]);

        int count = 0;
        for (int i = 1; i <= N; i++) if (dist[i] == max) count++;

        return count;
    }

    // 가지치기 DFS: 더 짧게 도달할 때만 갱신하고 확장
    private void dfs(int u, int d) {
        if (d >= dist[u]) return;   // 이미 더 짧은 경로가 있으면 중단
        dist[u] = d;
        for (int v : adj[u]) {
            dfs(v, d + 1);
        }
    }
}
