import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 최대공약수 구하기 (유클리드 호제법)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcdValue = gcd(a, b);
            long lcm = (long)a * b / gcdValue; // LCM 구하기

            sb.append(lcm).append('\n');
        }

        System.out.print(sb);
    }
}
