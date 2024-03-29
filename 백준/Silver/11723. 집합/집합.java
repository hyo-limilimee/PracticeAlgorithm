import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        int S = 0;  // 집합

        // M회 반복
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num = 0;

            switch (str) {
                case "add":
                    // 0~19로 표현 해야 하기 때문에 -1
                    num = Integer.parseInt(st.nextToken()) - 1;
                    // or 연산 -> num번째 비트만 1로
                    S = S | (1 << num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken()) - 1;
                    // and 연산 -> num번째 비트만 0으로
                    S = S & ~(1 << num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken()) - 1;
                    // num 번째 비트만 1로 -> temp 사용
                    int temp = S & (1 << num);
                    // 만약 0이면 없음
                    sb.append(((temp == 0) ? 0 : 1) + "\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken()) - 1;
                    // xor 연산 진행 -> 0이면 1로, 1이면 0으로
                    S = S ^ (1 << num);
                    break;
                case "all":
                    S = (1 << 21) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}