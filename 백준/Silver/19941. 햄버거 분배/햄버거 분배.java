import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static char[] table;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        table = str.toCharArray();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            int from = Math.max(0, i - K);
            int to = Math.min(N - 1, i + K);

            if (table[i] == 'P') {
                for (int j = from; j <= to; j++) {
                    if (table[j] == 'H') {
                        table[j] = 'X';
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
