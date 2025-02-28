class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            String merged = Integer.toBinaryString(arr1[i] | arr2[i]);
            while (merged.length() < n) {
                merged = "0" + merged;
            }
            answer[i]= merged.replace('1','#').replace('0',' ');
        }
        
        
        return answer;
    }
}