import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int mn = arr[0];
        long eaten = 0;
        int days = 0;

        for (int i = 1; i < N; i++) {
            if (arr[i] > mn) {
                eaten += (arr[i] - mn);
                days++;
            }
        }

        System.out.println(eaten + " " + days);
    }
}
