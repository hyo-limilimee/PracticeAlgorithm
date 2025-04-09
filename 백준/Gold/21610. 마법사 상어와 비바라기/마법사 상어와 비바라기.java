import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] A;
    static int[][] cloud;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1][N + 1];
        cloud = new int[N + 1][N + 1];
        // 구름이 위치하는 곳
        cloud[N][1] = cloud[N][2] = cloud[N - 1][1] = cloud[N - 1][2] = 1;

        // 1-based
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            moveClouds(d, s);
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum += A[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void moveClouds(int d, int s) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] newClouds = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cloud[i][j] == 1) {
                    int nx = (i + dx[d] * s) % N;
                    int ny = (j + dy[d] * s) % N;

                    if (nx <= 0) nx += N;
                    if (ny <= 0) ny += N;

                    A[nx][ny]++;
                    queue.offer(new int[]{nx, ny});
                    newClouds[nx][ny] = 2;
                }
            }
        }
        cloud = newClouds;
        copyBug(queue);
    }

    private static void copyBug(Queue<int[]> queue) {
        int[] ddx = {-1, -1, 1, 1};
        int[] ddy = {-1, 1, -1, 1};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            int count = 0;
            for (int d = 0; d < 4; d++) {
                int nr = r + ddx[d];
                int nc = c + ddy[d];

                if (nr >= 1 && nr <= N && nc >= 1 && nc <= N) {
                    if (A[nr][nc] > 0) count++;
                }
            }

            A[r][c] += count;
        }

        makeClouds();
    }

    private static void makeClouds() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (A[i][j] >= 2 && cloud[i][j] != 2) {
                    cloud[i][j] = 1;
                    A[i][j] -= 2;
                }
            }
        }
    }
}
