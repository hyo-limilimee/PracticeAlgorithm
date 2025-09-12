import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() < M) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> words = new ArrayList<>(map.keySet());

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int freqA = map.get(a), freqB = map.get(b);
                if (freqA != freqB) return freqB - freqA;         // 빈도 내림차순
                if (a.length() != b.length()) return b.length() - a.length(); // 길이 내림차순
                return a.compareTo(b);                            // 사전순 오름차순
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String w : words) sb.append(w).append("\n");
        System.out.print(sb);
    }
}
