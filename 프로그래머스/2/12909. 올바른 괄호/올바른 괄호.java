class Solution {
    public boolean solution(String s) {
        int count = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {  // ')'
                count--;
            }
            
            // ')'가 더 많아진 순간 → 실패
            if (count < 0) return false;
        }
        
        // 모든 괄호가 짝이 맞아 떨어졌는가?
        return count == 0;
    }
}
