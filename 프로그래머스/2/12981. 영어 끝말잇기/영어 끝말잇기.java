import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> wordList = new ArrayList<>();
        boolean failed = false;
        int turn = 0;
        wordList.add(words[0]);
        String prev = words[0];
        
        for(int i = 1; i < words.length; i++){
            turn++;
            String w = words[i];
            
            // 이어지는 말인지 확인
            if(w.charAt(0) != prev.charAt(prev.length() - 1)){
                failed = true;
            }
            
            // 중복 단어인지 체크
            if(wordList.contains(w)){
                failed = true;
            }
            
            if(failed) break;
            
            wordList.add(w);
            prev = w;
        }
        
        if(!failed){
            return new int[] {0,0};
        }       
        
        return new int[]{turn % n + 1, turn / n + 1};
    }
}