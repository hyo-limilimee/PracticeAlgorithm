import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 시험장의 개수
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        // 총 감독관이 한 시험장에서 감시할 수 있는 응시자 수
        int B = Integer.parseInt(st.nextToken());

        // 부 감독관이 한 시험장에서 감시할 수 있는 응시자 수
        int C = Integer.parseInt(st.nextToken());

        long answer = N;

        for (int j = 0; j < N; j++) {
            arr[j] -= B;

            if (arr[j] > 0) {
                answer += arr[j] / C;

                if (arr[j] % C != 0) {
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}
