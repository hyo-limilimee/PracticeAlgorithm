import java.io.*;
import java.util.*;

public class Main {
    public static int[] score;  // 계단 별 점수 저장
    public static int[] dp;     // 총 점수 저장

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        score = new int[301];
        score[0] = 0;

        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[303];
        dp[0] = 0;
        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        dp[3] = Math.max(score[1], score[2]) + score[3];

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
        }

        System.out.println(dp[n]);
    }
}
