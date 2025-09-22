import java.io.*;

public class Main {
    static String answer = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int len = word.length();


        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                String a = reverse(word.substring(0, i));
                String b = reverse(word.substring(i, j));
                String c = reverse(word.substring(j));

                String current = a + b + c;
                compareDic(current);
            }
        }
        System.out.println(answer);
    }

    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    private static void compareDic(String curr) {
        if (answer.equals("")) {
            answer = curr;
            return;
        }

        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) < answer.charAt(i)) {
                answer = curr;
                return;
            } else if (curr.charAt(i) > answer.charAt(i)) {
                return;
            }
        }
    }
}
