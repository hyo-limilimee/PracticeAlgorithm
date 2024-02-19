import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null) {
            // 공백 기준으로 문자열 자르기
            StringTokenizer st = new StringTokenizer(str);
            String s = st.nextToken();
            String t = st.nextToken();

            // 문자열 별 포인터 설정
            int i = 0;  // 문자열 s에 대하여
            int j = 0;  // 문자열 t에 대하여

            while (i < s.length() && j < t.length()) {
                // 문자열 한 글자씩 비교하기
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                }
                j++;
            }

            if (i == s.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}