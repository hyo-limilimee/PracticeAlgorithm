import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] people;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        people = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[N];
        for (int i = 1; i <= N; i++) {
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                if (arr[j] == 0) {
                    if (cnt == people[i - 1]) {
                        arr[j] = i;
                        break;
                    }
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
