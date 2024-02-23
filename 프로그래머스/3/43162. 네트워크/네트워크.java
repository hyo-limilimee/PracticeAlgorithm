class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        
        // node 방문 정보 초기화
        for(int i = 0; i < computers.length; i++){
            visited[i] = false;
        }
        
        // 모든 node 방문        
        for(int i = 0; i < computers.length; i++){
            // 해당 노드를 방문하지 않은 경우
            if(visited[i] == false){
                answer++;
                dfs(i,visited,computers);
            }
        }
        
        return answer;
    }
    
    public void dfs(int node, boolean[] visited, int[][]computers){
        // 방문 -> visited = true
        visited[node] = true;
        
        // 해당 노드와 연결되어 있는 지 확인
        for(int i =0; i < computers.length; i++){
            // 이번에 방문한 적 없고, connection이 있는 경우
            if(visited[i] == false && computers[node][i] == 1){
                // dfs 호출
                dfs(i, visited, computers);
            }
        }
    }
}