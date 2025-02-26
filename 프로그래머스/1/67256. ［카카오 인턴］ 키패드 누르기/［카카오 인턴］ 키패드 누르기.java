class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int left = 10;
        int right = 12;
        
        for(int i = 0; i < numbers.length; i++){
            int num = numbers[i];
            if(num == 0){
                num = 11;
            }
            
            if(num == 1 || num == 4 || num == 7){
                answer+= "L";
                left = num;
            }
            
            if(num == 3 || num == 6 || num == 9){
                answer += "R";
                right = num;
            }
            
            if(num == 2 || num == 5 || num == 8 || num == 11){
                int leftDist = Math.abs(left - num) / 3 + Math.abs(left - num) % 3;
                int rightDist = Math.abs(right - num) / 3 + Math.abs(right - num) % 3;
                
                if(leftDist == rightDist){
                    if(hand.equals("right")){
                        right = num;
                        answer += "R";
                    }else{
                        left = num;
                        answer += "L";
                    }
                    
                }else if(leftDist < rightDist){
                    left = num;
                    answer += "L";
                }else{
                    right = num;
                    answer += "R";
                }
                
            }
        }
        
        
        return answer;
    }
}