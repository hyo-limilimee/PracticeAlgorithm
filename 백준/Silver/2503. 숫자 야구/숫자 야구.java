import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] isPossible = new boolean[1000];
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strikes = Integer.parseInt(st.nextToken());
            int balls = Integer.parseInt(st.nextToken());
            list.add(new int[]{num, strikes, balls});
        }

        for (int i = 123; i <= 987; i++) {
            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;
            if (a == 0 || b == 0 || c == 0) continue;
            if (a == b || a == c || b == c) continue;
            isPossible[i] = true;
        }

        for (int[] q : list) {
            int num = q[0];
            int s = q[1];
            int b = q[2];

            for (int i = 123; i <= 987; i++) {
                if (!isPossible[i]) continue;

                int[] result = check(i, num);
                if (result[0] != s || result[1] != b) {
                    isPossible[i] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 123; i <= 987; i++) {
            if (isPossible[i]) cnt++;
        }
        System.out.println(cnt);
    }

    private static int[] check(int target, int guess) {
        int strike = 0, ball = 0;
        int[] t = {target / 100, (target / 10) % 10, target % 10};
        int[] g = {guess / 100, (guess / 10) % 10, guess % 10};

        for (int i = 0; i < 3; i++) {
            if (t[i] == g[i]) strike++;
            else if (t[i] == g[0] || t[i] == g[1] || t[i] == g[2]) ball++;
        }
        return new int[]{strike, ball};
    }
}
