import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int maxSum = 0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;

                checkT(i, j);
            }
        }
        System.out.println(maxSum);
    }

    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            maxSum = Math.max(sum, maxSum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
                visited[nx][ny] = false;
            }
        }

    }

    static void checkT(int x, int y) {
        int center = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int sum = center;
            boolean valid = true;

            for (int j = 0; j < 3; j++) {
                int dir = (i + j) % 4;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    valid = false;
                    break;
                }

                sum += arr[nx][ny];
            }
            if (valid) {
                maxSum = Math.max(maxSum, sum);
            }
        }
    }
}
