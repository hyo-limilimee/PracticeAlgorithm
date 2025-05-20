import java.util.*;

class Solution {
    private List<String> path = new ArrayList<>();
    private boolean[] visited;
    private String[][] tickets;
    private List<String> answer = null;
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> {
           if(a[0].equals(b[0])){
               return a[1].compareTo(b[1]);
           }else{
               return a[0].compareTo(b[0]);
           }
        });
        
        path.add("ICN");
        dfs("ICN", 0);
        
        return answer.toArray(new String[0]);
    }
    
    private void dfs(String current, int depth){
        if(depth == tickets.length){
            answer = new ArrayList<>(path);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                path.add(tickets[i][1]);
                
                dfs(tickets[i][1], depth + 1);
                if(answer != null) return;
                
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}