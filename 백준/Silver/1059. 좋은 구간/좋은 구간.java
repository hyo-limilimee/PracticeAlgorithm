import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int[] S = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());
        Arrays.sort(S);

        int start = 0;
        int end = 0;

        for (int i = 0; i < L; i++) {
            if (S[i] == n) {
                System.out.println(0);
                return;
            }

            if (S[i] < n) {
                start = S[i];
            }

            if (S[i] > n) {
                end = S[i];
                break;
            }
        }

        if (end == 0) end = 10001;

        int cnt =  (n - start) * (end - n) - 1;
        System.out.println(cnt);

    }
}
