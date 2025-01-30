import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] scores = new int[301];
        scores[0] = 0;

        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[303];
        dp[0] = 0;
        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];
        dp[3] = Math.max(scores[1], scores[2]) + scores[3];

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + scores[i - 1], dp[i - 2]) + scores[i];
        }
        System.out.println(dp[n]);
    }
}
