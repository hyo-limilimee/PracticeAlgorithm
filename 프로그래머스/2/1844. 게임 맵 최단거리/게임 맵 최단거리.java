import java.util.*;

class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        this.maps = maps;
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        
        answer = bfs(0,0);
        
        if(answer == 0){
            answer = -1;
        }
        
        return answer;
    }
    
    public int bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            if(node.x == maps.length - 1 && node.y == maps[0].length - 1){
                return node.count;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx >=0 && nx < maps.length && ny >= 0 && ny < maps[0].length){
                    if(!visited[nx][ny] && maps[nx][ny]!=0){
                        queue.add(new Node(nx, ny, node.count+1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return 0;
    }
}













