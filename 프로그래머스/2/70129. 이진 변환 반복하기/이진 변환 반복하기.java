class Solution {
    public int[] solution(String s) {
        int count = 0;
        int removed = 0;
        
        while(!s.equals("1")){
            int zeros = 0;
            
            for(char c: s.toCharArray()){
                if(c == '0') zeros++;
            }
            
            removed += zeros;
            int len = s.length()-zeros;
            s = Integer.toBinaryString(len);
            count++;
        }
        return new int[] {count, removed};
    }
}