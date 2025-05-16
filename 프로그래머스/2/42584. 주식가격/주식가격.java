import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++){
            int value = prices[i];
            int count = 0;
            
            for(int j = i + 1; j < prices.length; j++){
                count++;
                if(value > prices[j]){
                    break;
                }
            }            
           answer[i] = count;
        }
        
        return answer;
    }
}