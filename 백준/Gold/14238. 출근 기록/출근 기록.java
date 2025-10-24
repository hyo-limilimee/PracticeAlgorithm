
import java.io.*;

public class Main {
    static int[][][][][] dp;
    static char[] result;
    static int totalA, totalB, totalC;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        N = s.length();

        totalA = totalB = totalC = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'A') totalA++;
            else if (ch == 'B') totalB++;
            else totalC++;
        }

        // dp[a][b][c][last][secondLast]
        dp = new int[totalA+1][totalB+1][totalC+1][4][4];
        result = new char[N];

        if (dfs(totalA, totalB, totalC, 3, 3, 0)) {
            System.out.println(new String(result));
        } else {
            System.out.println(-1);
        }
    }

    static boolean dfs(int a, int b, int c, int last, int secondLast, int depth) {
        if (a < 0 || b < 0 || c < 0) return false;
        if (a == 0 && b == 0 && c == 0) return true;

        if (dp[a][b][c][last][secondLast] == -1) return false;
        if (dp[a][b][c][last][secondLast] == 1) return true;

        // A 선택
        result[depth] = 'A';
        if (dfs(a-1, b, c, 0, last, depth+1)) {
            dp[a][b][c][last][secondLast] = 1;
            return true;
        }

        // B 선택 (연속 불가)
        if (last != 1) {
            result[depth] = 'B';
            if (dfs(a, b-1, c, 1, last, depth+1)) {
                dp[a][b][c][last][secondLast] = 1;
                return true;
            }
        }

        // C 선택 (직전 2일간 C가 있으면 불가)
        if (last != 2 && secondLast != 2) {
            result[depth] = 'C';
            if (dfs(a, b, c-1, 2, last, depth+1)) {
                dp[a][b][c][last][secondLast] = 1;
                return true;
            }
        }

        dp[a][b][c][last][secondLast] = -1;
        return false;
    }
}
