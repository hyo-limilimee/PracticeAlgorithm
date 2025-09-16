import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Set<Character> used = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            List<String> words = new ArrayList<>();
            while (st.hasMoreTokens()) {
                words.add(st.nextToken());
            }

            int shortIndex = -1;
            int wordIndex = -1;

            for (int j = 0; j < words.size(); j++) {
                char c = Character.toLowerCase(words.get(j).charAt(0));
                if (!used.contains(c)) {
                    shortIndex = 0;
                    wordIndex = j;
                    used.add(c);
                    break;
                }
            }

            if (shortIndex == -1) {
                outer:
                for (int j = 0; j < words.size(); j++) {
                    for (int k = 0; k < words.get(j).length(); k++) {
                        char c = Character.toLowerCase(words.get(j).charAt(k));
                        if (!used.contains(c)) {
                            shortIndex = k;
                            wordIndex = j;
                            used.add(c);
                            break outer;
                        }
                    }
                }
            }

            for (int j = 0; j < words.size(); j++) {
                if (j > 0) sb.append(" ");
                if (j == wordIndex) {
                    for (int k = 0; k < words.get(j).length(); k++) {
                        if (k == shortIndex) {
                            sb.append("[").append(words.get(j).charAt(k)).append("]");
                        } else {
                            sb.append(words.get(j).charAt(k));
                        }
                    }
                }else{
                    sb.append(words.get(j));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
