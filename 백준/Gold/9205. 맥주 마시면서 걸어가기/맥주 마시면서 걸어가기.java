import java.io.*;
import java.util.*;

public class Main {
    static int homeX, homeY, destX, destY, n;
    static int[][] stores;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < t; test_case++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());

            stores = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                stores[i][0] = Integer.parseInt(st.nextToken());
                stores[i][1] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[n];

            st = new StringTokenizer(br.readLine());
            destX = Integer.parseInt(st.nextToken());
            destY = Integer.parseInt(st.nextToken());

            bfs(homeX, homeY);
        }
        System.out.print(sb.toString());
    }

    static boolean isAvailable(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2) <= 1000;
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            if (isAvailable(currentX, currentY, destX, destY)) {
                sb.append("happy\n");
                return;
            }

            for (int i = 0; i < n; i++) {
                int storeX = stores[i][0];
                int storeY = stores[i][1];
                if (visited[i] == false && isAvailable(currentX, currentY, storeX, storeY)) {
                    visited[i] = true;
                    queue.offer(new int[]{storeX, storeY});
                }
            }
        }
        sb.append("sad\n");
    }
}