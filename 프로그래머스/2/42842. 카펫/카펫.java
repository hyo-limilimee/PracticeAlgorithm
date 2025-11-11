import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        
        for(int height = 3; height <= area / height; height++){
            int width = area / height;
            
            if((width - 2) * (height - 2) == yellow){
                return new int[] {width, height};
            }
        }
        
        return new int[2];
    }
}