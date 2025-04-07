import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] picked = new int[3];
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int index, int depth) {
        int sum = 0;
        if (depth == 3) {
            for (int i = 0; i < 3; i++) {
                sum += picked[i];
            }
            if (sum <= M) {
                answer = Math.max(answer, sum);
            }
            return;
        }

        for (int i = index; i < arr.length; i++) {
            picked[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }
}
