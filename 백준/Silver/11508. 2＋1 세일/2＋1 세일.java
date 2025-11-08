import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        C = new int[N];

        for (int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(C);

        int idx = 1;
        int min = 0;
        for (int i = N - 1; i >= 0; i--) {
            if(!(idx % 3 == 0) )min += C[i];
            idx++;
        }
        System.out.println(min);
    }
}
