import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int value, index;
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Pair[] arr = new Pair[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(arr, (a, b) -> a.value - b.value);

        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[arr[i].index] = i;  
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(" ");
        }
        System.out.println(sb);
    }
}
