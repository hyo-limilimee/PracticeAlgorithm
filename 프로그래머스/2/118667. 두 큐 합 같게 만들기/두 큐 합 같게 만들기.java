import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
         for(int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        long sum = sum1 + sum2;
        if(sum % 2 != 0) return -1;
        
        long target = sum / 2;
        int cnt = 0;
        int maxCnt = (queue1.length + queue2.length) * 2;
        
        while(cnt <= maxCnt){
            if(sum1 == sum2) return cnt;
            
            if(sum1 > target){
                int val = q1.poll();
                q2.offer(val);
                sum1 -= val;
                sum2 += val;
            }else{
                int val = q2.poll();
                q1.offer(val);
                sum1 += val;
                sum2 -= val;
            }
            cnt++;
        }
        
        return -1;
    }
}