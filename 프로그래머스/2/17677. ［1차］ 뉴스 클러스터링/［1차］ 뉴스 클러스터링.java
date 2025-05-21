import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> a = new HashMap<>();
        Map<String, Integer> b = new HashMap<>();
        
        for(int i = 0; i < str1.length() - 1; i++){
            Character x = str1.charAt(i);
            Character y = str1.charAt(i + 1);
            
            if(isInRange(x) && isInRange(y)){
               String sub = str1.substring(i, i + 2);
               a.put(sub, a.getOrDefault(sub, 0) + 1);
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++){
            Character x = str2.charAt(i);
            Character y = str2.charAt(i + 1);
            
            if(isInRange(x) && isInRange(y)){
               String sub = str2.substring(i, i + 2);
               b.put(sub, b.getOrDefault(sub, 0) + 1);
            }
        }
        
        int inter = 0;
        int union = 0;
        
        for(String key : a.keySet()){
            if(b.containsKey(key)){
                inter += Math.min(a.get(key), b.get(key));
            }
        }
        
        for(String key : a.keySet()){
            union += a.get(key);
        }
        
        for(String key : b.keySet()){
            union += b.get(key);
        }
        
        if(union == 0){
            return 65536;
        }
        
        double rate = (double) inter / (union - inter);
        return (int) (rate * 65536);
    }
    
    private boolean isInRange(Character x){
        if(x >= 'a' && x <= 'z'){
            return true;
        }
        return false;
    }
}