import java.util.*;
import java.io.*;

public class Main {
    static int N, K, L;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1}; // 동 남 서 북
    static int[] dy = {1, 0, -1, 0};
    static int dirIdx = 0;
    static int elapsed = 0;

    static Deque<int[]> snake = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = 1; // 사과
        }

        snake.offer(new int[]{0, 0});
        board[0][0] = 2; // 뱀 위치

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            move(x, dir);
        }

        // 남은 시간 무한으로 진행
        move(Integer.MAX_VALUE, "X");
    }

    static void move(int x, String dir) {
        while (elapsed < x) {
            elapsed++;

            int[] head = snake.peekLast();
            int nx = head[0] + dx[dirIdx];
            int ny = head[1] + dy[dirIdx];

            // 벽이나 자기 몸과 부딪히면 종료
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 2) {
                System.out.println(elapsed);
                System.exit(0);
            }

            snake.offerLast(new int[]{nx, ny});

            if (board[nx][ny] == 1) {
                board[nx][ny] = 2; // 사과 먹고 꼬리 유지
            } else {
                board[nx][ny] = 2; // 이동
                int[] tail = snake.pollFirst();
                board[tail[0]][tail[1]] = 0;
            }
        }

        // 방향 회전
        rotate(dir);
    }

    private static void rotate(String dir) {
        if (dir.equals("D")) {
            dirIdx = (dirIdx + 1) % 4;
        } else if (dir.equals("L")) {
            dirIdx = (dirIdx + 3) % 4;
        }
    }
}
