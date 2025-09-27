import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> keywords = new HashSet<>();
        for (int i = 0; i < N; i++) {
            keywords.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] words = br.readLine().split(",");
            for (String word : words) {
                if (keywords.contains(word)) {
                    keywords.remove(word);
                }
            }
            sb.append(keywords.size()).append("\n");
        }
        System.out.println(sb);
    }
}
