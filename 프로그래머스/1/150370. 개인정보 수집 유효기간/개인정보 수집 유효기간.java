import java.util.*;

class Solution {
    int tYear;
    int tMonth;
    int tDay;
    
    private boolean compareDate(int pYear, int pMonth, int pDay) {
        if (tYear > pYear) {
            return true;
        } else if (tYear == pYear) {
            if (tMonth > pMonth) {
                return true;
            } else if (tMonth == pMonth) {
                if (tDay >= pDay) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {  
        String[] date = today.split("\\.");
        tYear = Integer.parseInt(date[0]);
        tMonth = Integer.parseInt(date[1]);
        tDay = Integer.parseInt(date[2]);
            
        Map<String, Integer> termsInfo = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String[] termsInfoStr = terms[i].split(" ");
            termsInfo.put(termsInfoStr[0], Integer.parseInt(termsInfoStr[1]));
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++){
            String[] dateAndCondition = privacies[i].split(" ");
            String[] pDate = dateAndCondition[0].split("\\.");
            int pYear = Integer.parseInt(pDate[0]);
            int pMonth = Integer.parseInt(pDate[1]);
            int pDay = Integer.parseInt(pDate[2]);
            String condition = dateAndCondition[1];
            
            pMonth += termsInfo.get(condition);
            
            while(pMonth > 12){
                pYear++;
                pMonth -= 12;
            }
           
             if(compareDate(pYear, pMonth, pDay)){
                 answer.add(i+1);
             }
        }
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
        
        return result;
    }
}