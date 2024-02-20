import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int result = binarySearch(cards, N, num);
            sb.append(result).append(" ");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] cards, int N, int search) {
        int first = 0;
        int mid = 0;
        int last = N - 1;

        while (first <= last) {
            mid = (first + last) / 2;

            // 중앙값보다 찾는 값이 큰 경우
            if (cards[mid] < search) {
                first = mid + 1;
            } else if (search < cards[mid]) {
                last = mid - 1;
            } else {
                // 중앙값이 찾는 값이랑 같은 경우
                return 1;
            }
        }
        return 0;
    }
}
