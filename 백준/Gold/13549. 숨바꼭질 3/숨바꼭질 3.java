import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] dist;
    static int MAX = 1000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[MAX];
        Arrays.fill(dist, -1);

        bfs();

        System.out.println(dist[K]);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : new int[]{current * 2, current - 1, current + 1}) {
                if (next >= 0 && next < MAX) {
                    if (dist[next] == -1) {
                        if (next == current * 2) {
                            dist[next] = dist[current];
                        } else {
                            dist[next] = dist[current] + 1;
                        }
                        queue.offer(next);
                    }
                }
            }
        }
    }
}