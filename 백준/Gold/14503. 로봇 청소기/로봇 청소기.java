import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] map;
    static int r;
    static int c;
    static int d;
    static int count = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean();
        System.out.println(count);
    }

    static void clean() {
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                count++;
            }

            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (map[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                int back = (d + 2) % 4;
                int bx = r + dx[back];
                int by = c + dy[back];

                if (map[bx][by] == 1) {
                    return;
                } else {
                    r = bx;
                    c = by;
                }
            }
        }
    }
}
