import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int cntZero = 0;
        int cntOne = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') {
                cntZero++;
            } else {
                cntOne++;
            }
        }

        cntZero /= 2;
        cntOne /= 2;

        int i = 0;
        while (cntOne != 0) {
            if (S.charAt(i) == '1') {
                S = S.substring(0, i) + S.substring(i + 1);
                cntOne--;
                i -= 1;
            }
            i++;
        }

        int j = S.length() - 1;
        while (cntZero != 0) {
            if (S.charAt(j) == '0') {
                S = S.substring(0, j) + S.substring(j + 1);
                cntZero--;
                j = S.length();
            }
            j--;
        }

        System.out.println(S);
    }
}
