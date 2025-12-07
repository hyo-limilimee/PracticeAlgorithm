import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int zeroGroups = 0;
        int oneGroups = 0;

        if (S.charAt(0) == '0') zeroGroups++;
        else oneGroups++;

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                if (S.charAt(i) == '0') zeroGroups++;
                else oneGroups++;
            }
        }

        System.out.println(Math.min(zeroGroups, oneGroups));
    }
}
