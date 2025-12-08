import java.io.*;
import java.util.*;

public class Main {
    static int N, M, J;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 스크린 N칸
        M = Integer.parseInt(st.nextToken());   // 스크린 아래쪽에 M칸 차지하는 바구니
        J = Integer.parseInt(br.readLine());    // 떨어지는 사과 개수

        int min = 0;
        int max = M - 1;
        int answer = 0;

        for (int i = 0; i < J; i++) {
            int pos = Integer.parseInt(br.readLine()) - 1;

            if (pos >= min && pos <= max) continue;

            if (pos > max) {
                int diff = pos - max;
                min += diff;
                max += diff;
                answer += diff;

            } else if (pos < min) {
                int diff = min - pos;
                min -= diff;
                max -= diff;
                answer += diff;
            }
        }
        System.out.println(answer);
    }
}
