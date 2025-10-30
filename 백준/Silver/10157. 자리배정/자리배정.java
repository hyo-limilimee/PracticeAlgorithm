import java.io.*;
import java.util.*;

public class Main {
    static int c, r, k;
    static boolean[][] visited;

    // 상, 우, 하, 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        visited = new boolean[r + 1][c + 1];

        if (k > r * c) {
            System.out.println(0);
            return;
        }

        int x = 1, y = 1;
        int dir = 0;
        int num = 1;
        visited[y][x] = true;

        while (num < k) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 1 || nx > c || ny < 1 || ny > r || visited[ny][nx]) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
            visited[y][x] = true;
            num++;
        }
        System.out.println(x + " " + y);
    }
}
