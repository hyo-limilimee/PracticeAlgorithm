class Solution {
    public String solution(String s) {
        String[] parts = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String p : parts){
            int num = Integer.parseInt(p);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        return min + " " + max;
    }
}