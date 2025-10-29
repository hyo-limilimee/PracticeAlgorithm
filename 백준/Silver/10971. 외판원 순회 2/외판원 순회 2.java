import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, i, 1, 0);
            visited[i] = false;
        }

        System.out.println(answer);
    }

    private static void dfs(int start, int now, int count, int cost) {
        if (count == N) {
            if (arr[now][start] != 0) {
                answer = Math.min(answer, cost + arr[now][start]);
            }
            return;
        }

        for (int next = 0; next < N; next++) {
            if (!visited[next] && arr[now][next] != 0) {
                visited[next] = true;
                dfs(start, next, count + 1, cost + arr[now][next]);
                visited[next] = false;
            }
        }
    }
}
