import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] depth;
    static int[] order;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        depth = new int[N + 1];
        order = new int[N + 1];
        Arrays.fill(depth, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        bfs(R);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 1;

        queue.add(start);
        depth[start] = 0;
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (depth[next] == -1) {
                    depth[next] = depth[current] + 1;
                    order[next] = ++cnt;
                    queue.add(next);
                }
            }
        }
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += (long) depth[i] * order[i];
        }
        System.out.println(sum);
    }
}
