import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int N = id_list.length;
        
        Map<String, Integer> nameIndex = new HashMap<>();
        for(int i = 0; i < N; i++){
            nameIndex.put(id_list[i],i);
        }
        
        int[][] arr = new int[N][N];
        int[] answer = new int[N];
        
        for(int i = 0; i < report.length; i++){
            String[] str = report[i].split(" ");
            // 신고한 사람
            String a = str[0];
            // 신고 당한 사람
            String b = str[1];
            arr[nameIndex.get(a)][nameIndex.get(b)] = 1;
        }
        
        for(int i = 0; i < N; i++){
            int cnt = 0;
            for(int j = 0; j < N; j++){
                cnt += arr[j][i];
            }
            
            if(cnt >= k){
                for(int j = 0; j < N; j++){
                    if(arr[j][i] == 1){
                        answer[j]++;
                    }
                }
            }
        }
        
        return answer;
    }
}