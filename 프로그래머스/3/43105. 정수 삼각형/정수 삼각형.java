import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0]; 

            for (int j = 1; j < triangle[i].length - 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }

            dp[i][triangle[i].length - 1] = dp[i - 1][triangle[i - 1].length - 1] + triangle[i][triangle[i].length - 1];
        }

        int answer = 0;
        for (int k = 0; k < triangle[triangle.length - 1].length; k++) {
            answer = Math.max(answer, dp[triangle.length - 1][k]);
        }

        return answer;
    }
}
