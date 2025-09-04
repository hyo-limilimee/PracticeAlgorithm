import java.io.*;
import java.util.*;

public class Main {
    static int A, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[K + 1];

        queue.add(new int[]{A, 0});
        visited[A] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int num = curr[0];
            int cnt = curr[1];

            if (num == K) {
                System.out.println(cnt);
                return;
            }

            if (num + 1 <= K && !visited[num + 1]) {
                visited[num + 1] = true;
                queue.add(new int[]{num + 1, cnt + 1});
            }

            if (num * 2 <= K && !visited[num * 2]) {
                visited[num * 2] = true;
                queue.add(new int[]{num * 2, cnt + 1});
            }
        }

    }
}
