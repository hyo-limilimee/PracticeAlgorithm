import java.util.*;
import java.io.*;

public class Main {
    static int E, S, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int e = 1, s = 1, m = 1;
        int year = 1;

        while (true) {
            if (e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }

            year++;
            e++;
            s++;
            m++;

            if (e > 15) e = 1;
            if (s > 28) s = 1;
            if (m > 19) m = 1;
        }
    }

}