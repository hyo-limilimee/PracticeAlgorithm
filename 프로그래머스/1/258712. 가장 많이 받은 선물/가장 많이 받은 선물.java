import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        int[][] giftRecord = new int [N][N];
        int[] giftScore = new int[N];
        
        Map<String, Integer> nameToIndex = new HashMap();
        for(int i = 0; i < friends.length; i++){
            nameToIndex.put(friends[i], i);
        }
        
        for(int i = 0; i < gifts.length; i++){
            String[] str = gifts[i].split(" ");
            String from = str[0];
            String to = str[1];
            
            int giveIndex = nameToIndex.get(from);
            int recieveIndex = nameToIndex.get(to);
            giftRecord[giveIndex][recieveIndex]++;
            giftScore[giveIndex]++;
            giftScore[recieveIndex]--;
        }
        
        int[] nextMonthGifts = new int[N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                
                if(giftRecord[i][j] > giftRecord[j][i]){
                    nextMonthGifts[i]++;
                }else{
                    if(giftRecord[i][j] == giftRecord[j][i]){
                        if(giftScore[i] > giftScore[j]){
                             nextMonthGifts[i]++;
                        }
                    }
                }
            }
        }
        
        for(int giftCnt : nextMonthGifts){
            answer = Math.max(answer, giftCnt);
        }
        
        return answer;
    }
}