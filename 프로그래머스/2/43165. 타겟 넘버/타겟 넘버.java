import java.io.*;

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {        
        dfs(numbers, 0, target, 0);
        
        return answer;
    }
    
    private void dfs(int[] numbers, int depth, int target, int sum){
       // 마지막 노드까지 탐색한 경우
        if(depth == numbers.length){
            if(target == sum){
                answer++;
            }
        }
        else{
            dfs(numbers, depth+1, target, sum + numbers[depth]);
             dfs(numbers, depth+1, target, sum - numbers[depth]);
        }
        
    }
}