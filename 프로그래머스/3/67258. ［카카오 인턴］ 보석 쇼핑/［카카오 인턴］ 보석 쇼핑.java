import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalTypes = gemTypes.size();
        
        Map<String, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int answerLeft = 0, answerRight = 0;
        
        while(true){
            if (window.size() == totalTypes){
                if(right - left < minLen){
                    minLen = right - left;
                    answerLeft = left + 1;
                    answerRight = right;
                }
                
                // 왼쪽 포인터 줄이기 시도
                String leftGem = gems[left];
                window.put(leftGem, window.get(leftGem) - 1);
                if(window.get(leftGem) == 0){
                    window.remove(leftGem);
                }
                left++; // 포인터 이동
            }
            else{
                if(right == gems.length) break;
                String rightGem = gems[right];
                window.put(rightGem, window.getOrDefault(rightGem, 0) + 1);
                right++;
            }
        }
        return new int[] {answerLeft, answerRight};
    }
}