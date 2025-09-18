import java.io.*;
import java.util.*;

public class Main {
    
    public static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n;
    static int[][] map;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(dijkstra());
    }

    static int dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[][] costArr = new int[n][n]; // 각 칸까지의 최소 비용(부순 벽 개수) 저장 배열
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(costArr[i], INF);
        }

        q.add(new Node(0, 0, 0));
        costArr[0][0] = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            Node now = q.poll();

            // 현재 노드의 비용이 이미 기록된 최소 비용보다 크면 탐색할 필요가 없음 (메모리 초과 방지 핵심)
            if (now.cost > costArr[now.x][now.y]) {
                continue;
            }

            if (now.x == n - 1 && now.y == n - 1) {
                return now.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    // 다음 칸이 흰 방(1)이면 비용 그대로, 검은 방(0)이면 비용 +1
                    int nextCost = now.cost + (map[nx][ny] == 1 ? 0 : 1);
                    
                    // 다음 칸으로 가는 비용이 기존 최소 비용보다 적을 때만 갱신하고 큐에 추가
                    if (nextCost < costArr[nx][ny]) {
                        costArr[nx][ny] = nextCost;
                        q.add(new Node(nx, ny, nextCost));
                    }
                }
            }
        }
        return 0;
    }
}