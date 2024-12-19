import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수
        int P = Integer.parseInt(br.readLine());

        for (int i = 0; i < P; i++) {
            int cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];

            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int k = 0; k < 20; k++) {
                for (int l = 0; l < k; l++) {
                    if (arr[k] < arr[l]) {
                        cnt++;
                    }
                }
            }
            System.out.println(T + " " + cnt);
        }
    }
}
