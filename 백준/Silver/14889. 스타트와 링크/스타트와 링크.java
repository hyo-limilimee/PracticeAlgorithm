import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int diff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(diff);
    }

    private static void dfs(int index, int depth) {
        if (depth == N / 2) {
            calculateDiff();
            return;
        }

        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void calculateDiff() {
        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    sumA += map[i][j] + map[j][i];
                }
                if (!visited[i] && !visited[j]) {
                    sumB += map[i][j] + map[j][i];
                }
            }
        }
        diff = Math.min(diff, Math.abs(sumA - sumB));
    }
}
