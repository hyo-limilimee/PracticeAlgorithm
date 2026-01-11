class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                if (i == 0 || s.charAt(i - 1) == ' ') {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
