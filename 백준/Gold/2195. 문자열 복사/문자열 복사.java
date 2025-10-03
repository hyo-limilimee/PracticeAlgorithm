import java.io.*;

public class Main {
    static String S, P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        P = br.readLine();

        int cnt = 0;
        int idx = 0;

        while (idx < P.length()) {
            int len = 0;

            while (idx + len < P.length() && S.contains(P.substring(idx, idx + len + 1))) {
                len++;
            }

            cnt++;
            idx += len;
        }
        System.out.println(cnt);
    }
}
