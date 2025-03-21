import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int houseCount = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                houseCount += dfs(nx, ny);
            }
        }
        return houseCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int houseCount = dfs(i, j);
                    result.add(houseCount);
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (int count : result) {
            System.out.println(count);
        }
    }
}
