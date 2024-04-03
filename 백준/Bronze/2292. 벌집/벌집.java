import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int range = 2;

        if (n == 1) {
            System.out.print(1);
        } else {
            while (range <= n) {
                range = range + (6 * cnt);
                cnt++;
            }
            System.out.print(cnt);
        }
    }
}
