import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + R;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + G;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + B;
        }
        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}
