import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] relations;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        relations = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            relations[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relations[a].add(b);
            relations[b].add(a);
        }

        int min = Integer.MAX_VALUE;
        int answer = -1;
        for (int i = 1; i <= N; i++) {
            int val = bfs(i);
            if (val < min) {
                min = Math.min(min, val);
                answer = i;
            }
        }
        System.out.println(answer);
    }

    static int bfs(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : relations[curr]) {
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue.add(next);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) sum += dist[i];
        return sum;
    }
}
