import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int i = A.length() - 1;
        int j = B.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) sum += A.charAt(i--) - '0';
            if (j >= 0) sum += B.charAt(j--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        // 역순으로 만들어졌으므로 뒤집기
        sb.reverse();

        // 앞의 0 제거
        String result = sb.toString().replaceFirst("^0+(?!$)", "");

        System.out.println(result);
    }
}
