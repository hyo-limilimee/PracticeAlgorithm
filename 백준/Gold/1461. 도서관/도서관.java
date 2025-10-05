import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer> left, right;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        left = new ArrayList<>();
        right = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (n < 0) left.add(-n);
            else right.add(n);
        }

        Collections.sort(left, Collections.reverseOrder());
        Collections.sort(right, Collections.reverseOrder());

        int maxDist = 0;
        int answer = 0;

        for (int i = 0; i < left.size(); i += M) {
            answer += left.get(i) * 2;
            maxDist = Math.max(maxDist, left.get(i));
        }

        for (int i = 0; i < right.size(); i += M) {
            answer += right.get(i) * 2;
            maxDist = Math.max(maxDist, right.get(i));
        }
        answer -= maxDist;

        System.out.println(answer);
    }
}
