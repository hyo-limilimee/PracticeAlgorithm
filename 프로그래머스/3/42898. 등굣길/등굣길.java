/*
물에 잠기지 않은 지역으로 학교 가기
집에서 학교 가는 길 : m x n
집 : (1,1)
학교: (m,n)
*/

import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int dp[][] = new int[n + 1][m + 1];
        
        for(int[] puddle : puddles){
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        dp[1][1] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                
                if(i == 1 && j == 1){
                    continue;
                }
                
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                
                int top, left;
                
                if(i > 1){
                    top = dp[i - 1][j];
                }else{
                    top = 0;
                }
                
                if(j > 1){
                    left = dp[i][j - 1];
                }else{
                    left = 0;
                }
                
                dp[i][j] = (top + left) % 1000000007;
            }
        }
        return dp[n][m];
    }
}