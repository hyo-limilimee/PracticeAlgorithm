import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        // <번호, [진출차수, 진입차수]>
        Map<Integer, int[]> nodeDegrees = new HashMap<>();
        
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            
            nodeDegrees.putIfAbsent(from, new int[] {0,0});
            nodeDegrees.get(from)[1]++;
            
            nodeDegrees.putIfAbsent(to, new int[]{0,0});
            nodeDegrees.get(to)[0]++;
        }
        
        // 생성 노드 찾기
        for(Map.Entry<Integer, int[]> entry : nodeDegrees.entrySet()){
            int node = entry.getKey();
            int[] degrees = entry.getValue();
            int inDegree = degrees[0];
            int outDegree = degrees[1];
            
            if(inDegree == 0 && outDegree >= 2){
                answer[0] = node;
                break;
            }
        }
        
        int barCnt = 0;
        int eightCnt = 0;
        
        for(Map.Entry<Integer, int[]> entry : nodeDegrees.entrySet()){
            int node = entry.getKey();
            int[] degrees = entry.getValue();
            int inDegree = degrees[0];
            int outDegree = degrees[1];
            
            if(node == answer[0]) continue;
            
            if(inDegree >= 1 && outDegree == 0){
                barCnt++;
            }
            
            if(inDegree >= 2 && outDegree >= 2){
                eightCnt++;
            }
        }
        
        int totalCnt = nodeDegrees.get(answer[0])[1];
        
        answer[1] = totalCnt - barCnt - eightCnt;
        answer[2] = barCnt;
        answer[3] = eightCnt;
        
        return answer;
    }
}