import java.io.*;
import java.util.*;

public class Main {
    static int r, c, t;
    static int[][] map;
    static int cleanerA, cleanerB;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r + 1][c + 1];
        boolean exists = false;

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    if (exists) {
                        cleanerB = i;
                    } else {
                        cleanerA = i;
                        exists = true;
                    }
                }
            }
        }

        for (int i = 0; i < t; i++) {
            spread();
            upCycle(cleanerA);
            downCycle(cleanerB);
        }

        int sum = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (map[i][j] > 0) sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    static void spread() {
        int[][] temp = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (map[i][j] > 0) {
                    int spreadCnt = 0;
                    int amount = map[i][j] / 5;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];

                        if (nx > 0 && nx <= r && ny > 0 && ny <= c && map[nx][ny] != -1) {
                            temp[nx][ny] += amount;
                            spreadCnt++;
                        }
                    }
                    temp[i][j] += map[i][j] - (amount * spreadCnt);
                }
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (map[i][j] != -1) map[i][j] = temp[i][j];
            }
        }
    }

    static void upCycle(int cleaner) {
        // 위쪽
        for (int i = cleaner - 1; i > 1; i--) map[i][1] = map[i - 1][1];
        // 왼쪽 → 오른쪽
        for (int j = 1; j < c; j++) map[1][j] = map[1][j + 1];
        // 아래쪽
        for (int i = 1; i < cleaner; i++) map[i][c] = map[i + 1][c];
        // 오른쪽 → 왼쪽
        for (int j = c; j > 2; j--) map[cleaner][j] = map[cleaner][j - 1];

        map[cleaner][2] = 0;
    }


    static void downCycle(int cleaner) {
        // 아래쪽
        for (int i = cleaner + 1; i < r; i++) map[i][1] = map[i + 1][1];
        // 왼쪽 → 오른쪽
        for (int j = 1; j < c; j++) map[r][j] = map[r][j + 1];
        // 위쪽
        for (int i = r; i > cleaner; i--) map[i][c] = map[i - 1][c];
        // 오른쪽 → 왼쪽
        for (int j = c; j > 2; j--) map[cleaner][j] = map[cleaner][j - 1];

        map[cleaner][2] = 0;
    }
}