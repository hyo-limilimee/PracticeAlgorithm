import java.util.*;
import java.io.*;

public class Main {
    static int[] T;
    static int[] P;
    static int[] dp;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            // 상담을 건너뛴 경우
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // 상담을 수행한 경우
            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }
        System.out.println(dp[N + 1]);
    }
}