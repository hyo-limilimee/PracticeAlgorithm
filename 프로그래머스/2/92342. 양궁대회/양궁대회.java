class Solution {
    int[] ryan; // 라이언이 쏜 화살 배열
    int[] apeach; // 어피치가 쏜 화살 배열
    int maxDiff = 0; // 최대 점수 차이
    int[] result = {-1};
    
    public int[] solution(int n, int[] info) {
        ryan = new int[11];
        apeach = info;
        
        dfs(0, n);
        
        return result;
    }
    
    private void dfs(int depth, int arrowsLeft){
        if(arrowsLeft == 0){
            calculateScore();
            return;
        }
        
        if(depth == 10){
            ryan[depth] = arrowsLeft;
            calculateScore();
            ryan[depth] = 0;
            return;
        }
        
        if(arrowsLeft > apeach[depth]){
            ryan[depth] = apeach[depth] + 1;
            dfs(depth + 1, arrowsLeft - ryan[depth]);
            ryan[depth] = 0;
        }
        
        dfs(depth + 1, arrowsLeft);
    }
    
    private void calculateScore(){
        int ryanScore = 0;
        int apeachScore = 0;
        
        for(int i = 0; i < 11; i++){
            int point = 10 - i;
            
            if(ryan[i] == 0 && apeach[i] == 0) continue;
            
            if(apeach[i] >= ryan[i]){
                apeachScore += point;
            }else{
                ryanScore += point;
            }
        }
        
        int diff = ryanScore - apeachScore;
        
        if(diff > 0 && diff >= maxDiff){
            if(diff == maxDiff){
                for(int i = 10; i >= 0; i--) {
                    if(ryan[i] > result[i]) {
                        maxDiff = diff;
                        result = ryan.clone();
                        break;
                    } else if(ryan[i] < result[i]) {
                        break;
                    }
                }
            }else{
                maxDiff = diff;
                result = ryan.clone();
            }
        }
    }
}