import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long maxTime = (long) times[times.length-1] * n;
        long minTime = 1;
        long answer = maxTime;
        
        while(minTime <= maxTime){
            long midTime = (minTime + maxTime)/2;
            long temp_num = 0;
            
            for(int i = 0; i < times.length; i++){
                temp_num += midTime / times[i];
                if(temp_num >= n) break;
            }
            
            if(temp_num<n){
                minTime = midTime +1;
            }
            else{
                answer = Math.min(answer, midTime);
                maxTime = midTime -1;
            }
        }
        
        return answer;
    }
}