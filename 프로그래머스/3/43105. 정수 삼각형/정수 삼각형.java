import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            
            for(int j = 1; j < triangle[i].length; j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
            
             for(int k = 0; k < triangle.length; k++) {
            answer = Math.max(dp[triangle.length - 1][k], answer);
            }
        }
        
        return answer;
    }
}