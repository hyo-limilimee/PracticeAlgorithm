import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] picked;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        picked = new int[M];
        visited = new boolean[N + 1];
        pick(0);
        System.out.println(sb);
    }

    private static void pick(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(picked[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                picked[depth] = i;
                pick(depth + 1);
                visited[i] = false;
            }
        }
    }
}
