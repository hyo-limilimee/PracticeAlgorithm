import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        s = s.substring(2,s.length()-2).replace("},{","-");
        String[] sets = s.split("-");
        List<List<Integer>> tuple = new ArrayList<>();
        
        for (String set : sets) {
            List<Integer> element = new ArrayList<>();
            for (String num : set.split(",")) {
                element.add(Integer.parseInt(num));
            }
            tuple.add(element);
        }
        
        tuple.sort(Comparator.comparingInt(List::size));
        
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        
        for(List<Integer> element: tuple){
            for(int num : element){
                if(seen.add(num)){
                    result.add(num);
                }
            }
        }
        
        answer = result.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}