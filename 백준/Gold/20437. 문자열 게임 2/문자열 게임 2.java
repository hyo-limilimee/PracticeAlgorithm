import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            game(W, K);
        }
        System.out.println(sb);
    }

    private static void game(String W, int K) {
        List<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++) pos[i] = new ArrayList<>();

        for (int i = 0; i < W.length(); i++) {
            pos[W.charAt(i) - 'a'].add(i);
        }

        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < 26; i++) {
            List<Integer> list = pos[i];
            if (list.size() < K) continue;

            for (int j = 0; j + K - 1 < list.size(); j++) {
                int start = list.get(j);
                int end = list.get(j + K - 1);
                int len = end - start + 1;

                minLen = Math.min(minLen, len);
                maxLen = Math.max(maxLen, len);
            }
        }

        if (maxLen == Integer.MIN_VALUE) sb.append("-1\n");
        else sb.append(minLen).append(" ").append(maxLen).append("\n");
    }
}
