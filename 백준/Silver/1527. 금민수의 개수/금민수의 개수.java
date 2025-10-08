import java.io.*;
import java.util.*;

public class Main {
    static long A, B;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        search(0);
        System.out.println(cnt);
    }

    private static void search(long current) {
        if (current > B) {
            return;
        }
        if (current >= A) {
            cnt++;
        }
        search(current * 10 + 4);
        search(current * 10 + 7);
    }
}
