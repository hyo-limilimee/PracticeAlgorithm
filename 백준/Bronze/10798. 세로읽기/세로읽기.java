import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] words = new String[5];
        int maxLen = 0;

        for (int i = 0; i < 5; i++) {
            words[i] = br.readLine();
            maxLen = Math.max(maxLen, words[i].length());
        }

        StringBuilder sb = new StringBuilder();

        for (int col = 0; col < maxLen; col++) {   
            for (int row = 0; row < 5; row++) {   
                if (col < words[row].length()) {
                    sb.append(words[row].charAt(col));
                }
            }
        }

        System.out.println(sb.toString());
    }
}
