import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static ArrayList<int[]> cctv = new ArrayList<>();
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][][] cctvDirections = {
            {}, // 0번은 없음 (CCTV 없음)
            {{0}, {1}, {2}, {3}}, // 1번: 4가지
            {{0, 2}, {1, 3}},       // 2번: 좌우 or 상하
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번: ㄴ자 회전
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번: 3방향
            {{0, 1, 2, 3}}           // 5번: 전방향
    };
    static int minCnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctv.add(new int[]{i, j});
                }
            }
        }

        monitor(0, map);
        System.out.println(minCnt);
    }

    static void monitor(int depth, int[][] map) {
        if (depth == cctv.size()) {
            calculateMinCnt(map);
            return;
        }

        int[] current = cctv.get(depth);
        int x = current[0];
        int y = current[1];
        int type = map[x][y];

        for (int[] dirs : cctvDirections[type]) {
            int[][] copied = deepCopy(map);
            for (int dir : dirs) {
                spread(x, y, dir, copied);
            }
            monitor(depth + 1, copied);
        }
    }

    static void spread(int x, int y, int direction, int[][] map) {
        int nx = x + directions[direction][0];
        int ny = y + directions[direction][1];

        while (0 <= nx && nx < N && 0 <= ny && ny < M) {
            if (map[nx][ny] == 6) break; // 벽

            if (map[nx][ny] == 0) map[nx][ny] = 7;

            nx += directions[direction][0];
            ny += directions[direction][1];
        }
    }

    static void calculateMinCnt(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        minCnt = Math.min(minCnt, cnt);
    }

    static int[][] deepCopy(int[][] map) {
        int[][] copied = new int[N][M];
        for (int i = 0; i < N; i++) {
            copied[i] = map[i].clone();
        }
        return copied;
    }
}
