import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("src/swea_score/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] scores = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                sum += scores[i];
            }

            boolean[] dp = new boolean[sum + 1];
            dp[0] = true; // 0점은 항상 가능

            for (int p : scores) {
                for (int s = sum; s >= p; s--) {
                    if (dp[s - p]) dp[s] = true;
                }
            }

            int count = 0;
            for (boolean can : dp) {
                if (can) count++;
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
