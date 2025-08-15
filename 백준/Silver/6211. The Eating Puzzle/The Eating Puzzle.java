import java.io.*;
import java.util.*;

public class Main {
    static int C, B;
    static int[] buckets;
    static int maxSum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        buckets = new int[B];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            buckets[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(maxSum);
    }

    private static void dfs(int depth, int currentSum) {
        if (currentSum > C) return;
        if (depth == B) {
            if (currentSum > maxSum) maxSum = currentSum;
            return;
        }

        dfs(depth + 1, currentSum);
        dfs(depth + 1, currentSum + buckets[depth]);
    }
}
