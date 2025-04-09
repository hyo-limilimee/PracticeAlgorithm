import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};

    static int sharkSize = 2;
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
            map[sharkX][sharkY] = 0;

            ate++;
            if (ate == sharkSize) {
                sharkSize++;
                ate = 0;
            }
        }

        System.out.println(time);
    }

    private static Fish findFish(int sx, int sy) {
        List<Fish> candidates = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] dist = new int[N][N];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sx, sy});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[current[0]][current[1]] + 1;

                if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                    candidates.add(new Fish(nx, ny, dist[nx][ny]));
                }

                queue.offer(new int[]{nx, ny});
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
