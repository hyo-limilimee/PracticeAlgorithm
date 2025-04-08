import java.util.*;
import java.io.*;

public class Main {
    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;
    static int days = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = bfs(i, j);

                        if (union.size() > 1) {
                            moved = true;
                            redistribute(union);
                        }
                    }
                }
            }
            if (!moved) break;
            days++;
        }
        System.out.println(days);
    }

    static private List<int[]> bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        queue.offer(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                int diff = Math.abs(A[current[0]][current[1]] - A[nx][ny]);
                if (diff >= L && diff <= R) {
                    queue.offer(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return union;
    }

    static private void redistribute(List<int[]> union) {
        int sum = 0;
        for (int[] position : union) {
            sum += A[position[0]][position[1]];
        }

        int avg = sum / union.size();

        for (int[] position : union) {
            A[position[0]][position[1]] = avg;
        }
    }
}
