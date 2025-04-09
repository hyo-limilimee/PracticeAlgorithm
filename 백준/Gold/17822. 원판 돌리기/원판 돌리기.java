import java.util.*;
import java.io.*;

public class Main {
    static int N, M, T;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        board = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            rotate(x, d, k);
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum += board[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void rotate(int x, int d, int k) {
        for (int i = x; i <= N; i += x) {
            int[] temp = new int[M + 1];
            if (d == 0) { // 시계 방향
                for (int j = 1; j <= M; j++) {
                    int nj = (j + k - 1) % M + 1;
                    temp[nj] = board[i][j];
                }
            } else { // 반시계 방향
                for (int j = 1; j <= M; j++) {
                    int nj = (j - k - 1 + M) % M + 1;
                    temp[nj] = board[i][j];
                }
            }
            board[i] = temp;
        }

        erase();
    }

    private static void erase() {
        boolean[][] visited = new boolean[N + 1][M + 1];
        boolean flag = false;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (board[i][j] == 0 || visited[i][j]) continue;

                Queue<int[]> q = new LinkedList<>();
                List<int[]> group = new ArrayList<>();

                q.offer(new int[]{i, j});
                visited[i][j] = true;
                group.add(new int[]{i, j});
                int target = board[i][j];

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        // 좌우 원형 처리
                        if (ny < 1) ny = M;
                        if (ny > M) ny = 1;

                        if (nx < 1 || nx > N) continue;
                        if (visited[nx][ny]) continue;
                        if (board[nx][ny] != target) continue;

                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        group.add(new int[]{nx, ny});
                    }
                }

                if (group.size() > 1) {
                    flag = true;
                    for (int[] pos : group) {
                        board[pos[0]][pos[1]] = 0;
                    }
                }
            }
        }

        if (!flag) {
            int sum = 0, cnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (board[i][j] > 0) {
                        sum += board[i][j];
                        cnt++;
                    }
                }
            }

            if (cnt == 0) return;

            double avg = (double) sum / cnt;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (board[i][j] == 0) continue;
                    if (board[i][j] > avg) board[i][j]--;
                    else if (board[i][j] < avg) board[i][j]++;
                }
            }
        }
    }
}
