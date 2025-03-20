import java.util.*;

class Solution {
    int[] dx = {-1, 0, 1, 0};  
    int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int row = maps.length;  // 행 (세로)
        int col = maps[0].length;  // 열 (가로)
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});  
        
        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;
        maps[0][0] = 1;  
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            if(x == row - 1 && y == col - 1){
                return maps[x][y];  
            }
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visited[nx][ny] && maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    maps[nx][ny] = maps[x][y] + 1; 
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        return -1;  
    }
}
