import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int t = 1; t <= N; t++) {
            String[] words = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();

            sb.append("Case #").append(t).append(": ");
            for (int i = words.length - 1; i >= 0; i--) {
                sb.append(words[i]);
                if (i > 0) sb.append(" ");
            }
            System.out.println(sb);
        }
    }
}
