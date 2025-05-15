import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            queue.offer(0);
        }
        
        int totalWeight = 0;
        int time = 0;
        int index = 0;
        
        while(index < truck_weights.length){
            totalWeight -= queue.poll();
    
            if(totalWeight + truck_weights[index] <= weight){
                queue.offer(truck_weights[index]);
                totalWeight += truck_weights[index++];
            }else{
                queue.offer(0);
            }
            
            time++;
        }
        
        time += bridge_length;
        
        return time;
    }
}