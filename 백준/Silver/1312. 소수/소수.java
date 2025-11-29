import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        A %= B;

        int digit = 0;
        for (int i = 0; i < N; i++) {
            A *= 10;
            digit = A / B;
            A %= B;
        }
        System.out.println(digit);
    }
}
