import java.io.*;

public class Main {
    static int N;
    static long[][] dp;
    static final long NUM = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10];

        for (int d = 1; d <= 9; d++) {
            dp[1][d] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int d = 0; d <= 9; d++) {
                if (d == 0) {
                    dp[i][d] = dp[i - 1][1] % NUM;
                } else if (d == 9) {
                    dp[i][d] = dp[i - 1][8] % NUM;
                } else {
                    dp[i][d] = (dp[i - 1][d - 1] + dp[i - 1][d + 1]) % NUM;
                }
            }
        }

        long answer = 0;
        for (int d = 0; d <= 9; d++) {
            answer += dp[N][d];
        }
        System.out.println(answer % NUM);
    }
}
