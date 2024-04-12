import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // 	[1, 5, 2, 6, 3, 7, 4]
        for(int i = 0; i < commands.length; i++){
            int start = commands[i][0]; // 2
            int end = commands[i][1];   // 5
            int rank = commands[i][2];  // 3
            int[] temp = new int[end - start + 1];  //4
            
            int k = 0;
            for(int j = start - 1; j < end; j++){   //j = 1 ~ 4
                temp[k] = array[j]; //23567
                k++;
            }
            Arrays.sort(temp);
            answer[i] = temp[rank - 1];
        }
        
        return answer;
    }
}
