import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken(); // 주어진 수
        int B = Integer.parseInt(st.nextToken()); // 진법

        int result = 0;
        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            int value;

            if ('0' <= c && c <= '9') {
                value = c - '0';
            } else {
                value = c - 'A' + 10;
            }

            result = result * B + value;
        }

        System.out.println(result);
    }
}
