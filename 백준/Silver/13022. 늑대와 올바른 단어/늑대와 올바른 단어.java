import java.io.*;
import java.util.*;

public class Main {
    static char[] wolf = {'w', 'o', 'l', 'f'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int i = 0;
        boolean flag = true;

        while (i < word.length()) {
            int[] cnt = new int[4];

            for (int j = 0; j < 4; j++) {
                if (i >= word.length() || word.charAt(i) != wolf[j]) {
                    flag = false;
                    break;
                }
                while (i < word.length() && word.charAt(i) == wolf[j]) {
                    cnt[j]++;
                    i++;
                }
            }

            if (!flag) break;

            if (!(cnt[0] == cnt[1] && cnt[1] == cnt[2] && cnt[2] == cnt[3])) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? 1 : 0);
    }
}
