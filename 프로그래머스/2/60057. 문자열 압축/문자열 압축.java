import java.util.*;

class Solution {
    public int solution(String s) {
        if(s.length() == 1){
            return 1;
        }
        
        int answer = s.length();
        
        for(int i = 1; i <= s.length() / 2; i++){
            int compressedLength = compress(s, i);
            
            answer = Math.min(answer, compressedLength);
        }
        
        return answer;
    }
    
    private int compress(String s, int unitLength){
        StringBuilder sb = new StringBuilder();
        
        String prev = s.substring(0, unitLength);
        int count = 1;
        
        for(int i = unitLength; i <= s.length() - unitLength; i+= unitLength){
            String current = s.substring(i, i + unitLength);
            
            if(prev.equals(current)){
                count++;
            }else{
                if(count > 1){
                    sb.append(count);
                }
                sb.append(prev);
                
                prev = current;
                count = 1;
            }
        }
        if(count > 1){
            sb.append(count);
        }
        sb.append(prev);
        
        int remainder = s.length() % unitLength;
        if(remainder > 0){
            sb.append(s.substring(s.length() - remainder));
        }
        return sb.length();
    }
}