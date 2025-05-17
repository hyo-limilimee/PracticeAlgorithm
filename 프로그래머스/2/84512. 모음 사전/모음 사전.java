class Solution {
    public int solution(String word) {
        int answer = 0;
        String vowel = "AEIOU";
        int[] count = {781, 156, 31, 6, 1};
        
        for(int i = 0; i < word.length(); i++){
            int vowelIdx = vowel.indexOf(word.charAt(i));
            answer += vowelIdx * count[i];
        }
       
        return answer + word.length();
    }
}