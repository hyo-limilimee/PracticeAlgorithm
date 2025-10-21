import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int b = Integer.parseInt(st.nextToken());
                broken[b] = true;
            }
        }
        int answer = Math.abs(N - 100);

        for (int i = 0; i < 999999; i++) {
            int len = getLength(i);

            if (len > 0) {
                int press = len + Math.abs(N - i);
                answer = Math.min(answer, press);
            }
        }
        System.out.println(answer);
    }

    static int getLength(int num) {
        if (num == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while (num > 0) {
            if (broken[num % 10]) {
                return 0;
            }
            len++;
            num /= 10;
        }
        return len;
    }
}
