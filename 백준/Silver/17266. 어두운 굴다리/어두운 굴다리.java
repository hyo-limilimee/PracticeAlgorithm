import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] X;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        X = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(X);

        binarySearch();
    }

    static void binarySearch() {
        int low = 0;
        int high = N;
        int answer = N;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canCover(mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(answer);
    }

    static boolean canCover(int height) {
        if (X[0] - height > 0) return false;

        for (int i = 1; i < M; i++) {
            if (X[i] - height > X[i - 1] + height) return false;
        }

        if (X[M - 1] + height < N) return false;

        return true;
    }
}
