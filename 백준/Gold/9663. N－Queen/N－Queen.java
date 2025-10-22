import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        nQueen(0);
        System.out.println(cnt);
    }

    private static void nQueen(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;

            if (isPossible(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    private static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[i] == arr[col]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
