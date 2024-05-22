import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(divide(0, 0, N));
    }

    public static int divide(int x, int y, int size) {
        if (size == 2) {
            int newArr[] = new int[4];
            int idx = 0;

            for (int i = x; i < x + 2; i++) {
                for (int j = y; j < y + 2; j++) {
                    newArr[idx++] = arr[i][j];
                }
            }

            Arrays.sort(newArr);
            return newArr[2];
        }

        else {
            int[] newArr = new int[4];
            size  = size / 2;

            newArr[0] = divide(x, y, size);
            newArr[1] = divide(x, y + size, size);
            newArr[2] = divide(x + size, y, size);
            newArr[3] = divide(x + size, y + size, size);

            Arrays.sort(newArr);
            return newArr[2];
        }
    }
}
