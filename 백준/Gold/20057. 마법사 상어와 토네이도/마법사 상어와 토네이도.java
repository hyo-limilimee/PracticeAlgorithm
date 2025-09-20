import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int[][] spreadX = {
            {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0},
            {0, 0, 1, 1, 2, 2, 1, 1, 3, 2},
            {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0},
            {0, 0, -1, -1, -2, -2, -1, -1, -3, -2}
    };
    static int[][] spreadY = {
            {0, 0, -1, -1, -2, -2, -1, -1, -3, -2},
            {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0},
            {0, 0, 1, 1, 2, 2, 1, 1, 3, 2},
            {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0}
    };

    static int[] percent = {1, 1, 7, 7, 10, 10, 2, 2, 5};

    static int[][] arr;
    static int answer = 0;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = n / 2;
        int y = n / 2;
        int moveCnt = 1;
        int dir = 0;

        while (true) {
            for (int t = 0; t < 2; t++) {
                for (int i = 0; i < moveCnt; i++) {
                    spread(x, y, dir);
                    x += dx[dir];
                    y += dy[dir];
                }
                dir = (dir + 1) % 4;
            }
            moveCnt++;

            if (moveCnt == n) {
                for (int i = 0; i < moveCnt - 1; i++) {
                    spread(x, y, dir);
                    x += dx[dir];
                    y += dy[dir];
                }
                break;
            }
        }

        System.out.println(answer);
    }

    private static void spread(int x, int y, int dir) {
        // 이동할 칸
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        int curr = arr[nx][ny];

        for (int i = 0; i < 9; i++) {
            int nnx = x + spreadX[dir][i];
            int nny = y + spreadY[dir][i];
            int plus = curr * percent[i] / 100;

            if (nnx < 0 || nny < 0 || nnx >= n || nny >= n) {
                // 나간 모래
                answer += plus;
            } else {
                arr[nnx][nny] += plus;
            }
            // 원래 칸에서 모래 줄이기
            arr[nx][ny] -= plus;
        }

        // 남은 모래 처리
        int ax = x + spreadX[dir][9];
        int ay = y + spreadY[dir][9];
        if (ax < 0 || ay < 0 || ax >= n || ay >= n) {
            // 격자 밖
            answer += arr[nx][ny];
        } else {
            arr[ax][ay] += arr[nx][ny];
        }
        // 기존 칸 비우기
        arr[nx][ny] = 0;
    }
}
