import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int money = Integer.parseInt(br.readLine());

            int q = money / 25;
            money %= 25;

            int d = money / 10;
            money %= 10;

            int n = money / 5;
            money %= 5;

            int p = money;

            sb.append(q).append(" ")
              .append(d).append(" ")
              .append(n).append(" ")
              .append(p).append("\n");
        }

        System.out.print(sb);
    }
}
