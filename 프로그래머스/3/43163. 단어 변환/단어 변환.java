import java.util.*;

class Solution {
    private class Word{
        String word;
        int depth;
        
        Word(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin, 0));
        boolean[] visited = new boolean[words.length];
        
        while(!queue.isEmpty()){
            Word current = queue.poll();
            
            if(current.word.equals(target)){
                return current.depth;
            }
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && isAdjacent(current.word, words[i])){
                    visited[i] = true;
                    queue.offer(new Word(words[i], current.depth + 1));
                }
            }
        }
        return 0;
    }
    
    private boolean isAdjacent(String a, String b){
        int diff = 0;
        
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
            }
            
            if(diff > 1){
                return false;
            }
        }
        
        return diff == 1;
    }
}