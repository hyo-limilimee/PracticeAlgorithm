class Solution {
    private int[] DISCOUNT_RATE = {10, 20, 30, 40};
    private int maxPlusCnt = 0;
    private int maxSaleCnt = 0;
    private int N;
    private int[] discounts;
    
    private void setDiscountRate(int index, int[][] users, int[] emoticons ){
        if(index == emoticons.length){
            calculateResult(users, emoticons);
            return;
        }
        
        for(int rate : DISCOUNT_RATE){
            discounts[index] = rate;
            setDiscountRate(index + 1, users, emoticons);
        }
    }
    
    private void calculateResult(int[][] users, int[] emoticons){
        int plusCnt = 0;
        int totalSale = 0;
        
        for(int[] user : users){
            int minDiscount = user[0];
            int limitPrice = user[1];
            
            int amount = 0;
            for(int i = 0; i < emoticons.length; i++){
                if(discounts[i] >= minDiscount){
                    amount += emoticons[i] * (100 - discounts[i]) / 100;
                }
            }
            
            if(amount >= limitPrice){
                plusCnt++;
            }else{
                totalSale += amount;
            }
            
            if(plusCnt > maxPlusCnt || plusCnt == maxPlusCnt && totalSale > maxSaleCnt){
                maxPlusCnt = plusCnt;
                maxSaleCnt = totalSale;
            }
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        N = emoticons.length;
        discounts = new int[N];
        
        setDiscountRate(0, users, emoticons);
        
        return new int[]{maxPlusCnt, maxSaleCnt};
    }
}