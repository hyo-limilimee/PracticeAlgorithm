class Solution {
    public int solution(int[][] board) {
        int max = 0;
        int n = board.length;
        int m = board[0].length;
        
        // DP를 board에 직접 적용
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && i > 0 && j > 0) {
                    board[i][j] = 
                        Math.min(board[i][j-1],
                        Math.min(board[i-1][j], board[i-1][j-1])) + 1;
                }
                max = Math.max(max, board[i][j]);
            }
        }
        
        return max * max;  // 넓이
    }
}
