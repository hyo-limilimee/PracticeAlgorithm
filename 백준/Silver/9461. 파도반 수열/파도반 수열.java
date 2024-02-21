import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());

            long arr[] = new long[101];
            arr[1] = 1L;
            arr[2] = 1L;
            arr[3] = 1L;
            arr[4] = 2L;

            for (int j = 4; j <= N; j++) {
                arr[j] = arr[j - 2] + arr[j - 3];
            }

            System.out.println(arr[N]);
        }
    }
}
