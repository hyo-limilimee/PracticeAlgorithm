class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1. 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        
        // 2. 소문자, 숫자, -, _, .를 제외한 문자 제거
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < new_id.length(); i++){
            Character ch = new_id.charAt(i);
            if(Character.isAlphabetic(ch) ||
              Character.isDigit(ch) ||
              ch == '-' || ch == '_' || ch == '.'){
                sb.append(ch);
            }
        }
        new_id = sb.toString();
        
        // 3. 마침표 여러개 -> 1개
        sb = new StringBuilder();
        boolean flag = false;
        for(int i = 0; i < new_id.length(); i++){
            Character ch = new_id.charAt(i);
            if(ch == '.'){
                if(!flag){
                    sb.append(ch);
                }
                flag = true;
            }else{
                sb.append(ch);
                flag = false;
            }
        }
        new_id = sb.toString();
        
        // 4. 마침표(.)가 처음이나 끝에 있으면 제거
        if(new_id.startsWith(".")){
            new_id = new_id.substring(1);
        }
        if(new_id.endsWith(".")){
            new_id = new_id.substring(0,new_id.length()-1);
        }
        
        // 5. 빈 문자열이면 a 대입
        if(new_id.isEmpty()){
            new_id = "a";
        }
        
        // 6. 길이 16자 이상이면 자르기
        if(new_id.length() >= 16){
            new_id = new_id.substring(0,15);
        }
        if(new_id.endsWith(".")){
            new_id = new_id.substring(0,new_id.length()-1);
        }
        
        // 7. 2자 이하면 길이 3될 때까지 이어서 붙이기
        while(new_id.length() <= 2){
            new_id += new_id.charAt(new_id.length()-1);
        }
        
        return new_id;
    }
}