import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> type = new HashMap<>();
        type.put("R", 0);
        type.put("T", 0);
        type.put("C", 0);
        type.put("F", 0);
        type.put("J", 0);
        type.put("M", 0);
        type.put("A", 0);
        type.put("N", 0);
        
        for(int i = 0; i < survey.length; i++){
            String[] surveyType = survey[i].split("");
            String typeA = surveyType[0];
            String typeB = surveyType[1];
            int choice = choices[i];
            
            if(choice < 4){
                type.put(typeA, type.get(typeA) + 4 - choice);
                
            }else if(choice > 4 ){
                type.put(typeB, type.get(typeB) + choice - 4);
            }
         }
        
        StringBuilder answer = new StringBuilder();
        
        answer.append(type.get("R") >= type.get("T") ? 'R' : 'T');
        answer.append(type.get("C") >= type.get("F") ? 'C' : 'F');
        answer.append(type.get("J") >= type.get("M") ? 'J' : 'M');
        answer.append(type.get("A") >= type.get("N") ? 'A' : 'N');
        
        return answer.toString();
    }
}