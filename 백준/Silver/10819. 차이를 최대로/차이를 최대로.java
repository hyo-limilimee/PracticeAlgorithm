import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int answer = 0;
    static int[] perm;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        perm = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == N) {
            answer = Math.max(answer, calc(perm));
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    static int calc(int[] p) {
        int sum = 0;
        for (int i = 0; i < N-1; i++) {
            sum += Math.abs(p[i] - p[i + 1]);
        }
        return sum;
    }
}
