import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};

    static int fishSize = 2;
    static int ate = 0;
    static int time = 0;

    static int sharkX = 0;
    static int sharkY = 0;

    static class Fish {
        int x, y, dist;
        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Fish fish = findFish(sharkX, sharkY);
            if (fish == null) break;

            time += fish.dist;
            sharkX = fish.x;
            sharkY = fish.y;
            map[fish.x][fish.y] = 0;

            ate++;
            if (ate == fishSize) {
                fishSize++;
                ate = 0;
            }
        }

        System.out.println(time);
    }

    static Fish findFish(int sx, int sy) {
        boolean[][] visited = new boolean[N][N];
        int[][] dist = new int[N][N];
        Queue<int[]> q = new LinkedList<>();
        List<Fish> candidates = new ArrayList<>();

        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > fishSize) continue; // 지나갈 수 없는 곳

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;

                if (map[nx][ny] > 0 && map[nx][ny] < fishSize) {
                    candidates.add(new Fish(nx, ny, dist[nx][ny]));
                }

                q.offer(new int[]{nx, ny});
            }
        }

        if (candidates.isEmpty()) return null;

        Collections.sort(candidates, (a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            if (a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        });

        return candidates.get(0);
    }
}
