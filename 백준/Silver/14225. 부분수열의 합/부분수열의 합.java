import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[20 * 100000];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        powerset(0, 0);

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println(i);
                return;
            }
        }
    }

    private static void powerset(int cnt, int sum) {
        if (cnt == N) {
            visited[sum] = true;
            return;
        }

        powerset(cnt + 1, sum);
        powerset(cnt + 1, sum + arr[cnt]);
    }
}
