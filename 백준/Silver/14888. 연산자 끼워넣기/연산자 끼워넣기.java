import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] A;
    static StringTokenizer st;
    static int[] operators;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수의 개수
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, A[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int index, int result) {
        if (index == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                int num = A[index];
                int next = result;

                if (i == 0) next += num;
                else if (i == 1) next -= num;
                else if (i == 2) next *= num;
                else {
                    if (result < 0) {
                        next = -(-result / num);
                    } else {
                        next = result / num;
                    }
                }

                dfs(index + 1, next);
                operators[i]++;
            }
        }
    }
}
