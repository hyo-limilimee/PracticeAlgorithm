import java.io.*;

public class Main {
    static String accept = " is acceptable.";
    static String notAccept = " is not acceptable.";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();

        while (!word.equals("end")) {
            boolean flag = true;
            boolean hasVowel = false;
            int vowelCnt = 0;
            int consonantCnt = 0;
            char prev = 0;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (isVowel(c)) {
                    hasVowel = true;
                    vowelCnt++;
                    consonantCnt = 0;
                } else {
                    consonantCnt++;
                    vowelCnt = 0;
                }

                if (vowelCnt == 3 || consonantCnt == 3) {
                    flag = false;
                    break;
                }

                if (i > 0 && c == prev && !(c == 'e' || c == 'o')) {
                    flag = false;
                    break;
                }

                prev = c;
            }

            if (!hasVowel) {
                flag = false;
            }

            if (flag) {
                sb.append("<").append(word).append(">").append(accept).append("\n");
            } else {
                sb.append("<").append(word).append(">").append(notAccept).append("\n");
            }

            word = br.readLine();
        }
        System.out.println(sb);
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
