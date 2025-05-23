import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] dist;
    static int[] count;
    static boolean[] visited;
    static int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[MAX + 1];
        count = new int[MAX + 1];
        visited = new boolean[MAX + 1];

        Arrays.fill(dist, -1);
        dist[N] = 0;
        count[N] = 1;

        bfs();
        System.out.println(dist[K]);
        System.out.println(count[K]);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next >= 0 && next <= MAX) {
                    // 아직 방문하지 않았고, 최소 시간인 경우
                    if (dist[next] == -1) {
                        dist[next] = dist[current] + 1;
                        count[next] = count[current];
                        queue.offer(next);
                    }
                    // 경로 추가
                    else if (dist[next] == dist[current] + 1) {
                        count[next] += count[current];
                    }
                }
            }
        }
    }
}

