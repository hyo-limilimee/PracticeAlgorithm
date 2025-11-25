import java.io.*;

public class Main {
    static String S, T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        StringBuilder sb = new StringBuilder(T);

        while (sb.length() > S.length()) {
            char last = sb.charAt(sb.length() - 1);

            if (last == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.deleteCharAt(sb.length() - 1).reverse();
            }
        }

        if (S.equals(sb.toString())) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
