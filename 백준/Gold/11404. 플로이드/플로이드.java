import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 100000000;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   // 시작 도시
            int b = Integer.parseInt(st.nextToken());   // 도착 도시
            int c = Integer.parseInt(st.nextToken());   // 비용

            dist[a][b] = Math.min(dist[a][b], c);
        }

        // 플로이도-워셜 알고리즘
        for (int k = 1; k <= n; k++) { // 중간 경로로 k 사용
            for (int i = 1; i <= n; i++) { // 출발 도시 i
                for (int j = 1; j <= n; j++) { // 도착 도시 j
                    if (dist[i][k] != INF && dist[k][j] != INF) { // 중간 경로가 유효한 경우
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    sb.append("0 ");
                } else {
                    sb.append(dist[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
