import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 물이 새는 곳의 위치
        L = Integer.parseInt(st.nextToken());   // 테이프의 길이
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = arr[0];
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if ((arr[i] - start + 1) > L) {
                start = arr[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
