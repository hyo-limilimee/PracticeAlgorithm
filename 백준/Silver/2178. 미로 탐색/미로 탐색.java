import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;

    private static void bfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] visited = new int[N][M];
        visited[0][0] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        System.out.println(visited[N - 1][M - 1]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0, 0);
    }
}
