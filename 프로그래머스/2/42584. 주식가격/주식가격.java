import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < prices.length; i++){
            int value = prices[i];
            int count = 0;
            
            for(int j = i + 1; j < prices.length; j++){
                count++;
                if(value > prices[j]){
                    break;
                }
            }            
            ans.add(count);
        }
        
        
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}