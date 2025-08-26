import java.io.*;
import java.util.*;

public class Main {

    // 다리(간선) 정보를 저장할 클래스, 다리 길이를 기준으로 오름차순 정렬
    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] parent;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int islandCount; // 섬의 총 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // --- 1단계: 섬 번호 붙이기 (Labeling Islands) ---
        islandCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 땅(1)이고 아직 방문 안 한 곳에서만 BFS 시작 -> 새로운 섬 발견
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandCount++;
                    labelIsland(i, j, islandCount);
                }
            }
        }

        // --- 2단계: 가능한 모든 다리 찾기 ---
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 섬의 일부인 땅에서 다리 건설 시도
                if (map[i][j] > 0) {
                    findBridges(i, j, pq);
                }
            }
        }

        // --- 3단계: 최소 스패닝 트리(MST) 구하기 (Kruskal's Algorithm) ---
        parent = new int[islandCount + 1];
        for (int i = 1; i <= islandCount; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int connectedBridges = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            
            // 두 섬이 아직 연결되지 않았다면 다리 건설 (사이클 방지)
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                totalCost += edge.cost;
                connectedBridges++;
            }
        }
        
        // --- 4단계: 최종 결과 확인 ---
        // 연결된 다리 수가 (섬의 총 개수 - 1)이 아니면 모든 섬 연결 불가능
        if (connectedBridges == islandCount - 1 && islandCount > 1) {
            System.out.println(totalCost);
        } else {
            System.out.println(-1);
        }
    }

    // BFS를 이용해 섬에 고유 번호 붙이기
    public static void labelIsland(int r, int c, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        map[r][c] = id;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curR = current[0];
            int curC = current[1];

            for (int i = 0; i < 4; i++) {
                int nr = curR + dx[i];
                int nc = curC + dy[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    map[nr][nc] = id;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    // 한 지점에서 4방향으로 다리 후보 탐색
    public static void findBridges(int r, int c, PriorityQueue<Edge> pq) {
        int startIslandId = map[r][c];

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            int bridgeLength = 0;

            // 한 방향으로 직진
            while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                // 같은 섬을 만나면 다리 건설 불가
                if (map[nr][nc] == startIslandId) {
                    break;
                }
                // 다른 섬을 만났을 때
                if (map[nr][nc] > 0) {
                    // 다리 길이가 2 이상이면 유효한 다리로 추가
                    if (bridgeLength >= 2) {
                        pq.add(new Edge(startIslandId, map[nr][nc], bridgeLength));
                    }
                    break;
                }
                // 바다를 만나면 다리 길이 증가 및 계속 직진
                bridgeLength++;
                nr += dx[i];
                nc += dy[i];
            }
        }
    }

    // Union-Find 연산
    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}