import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String patternStr = br.readLine();
        String[] pattern = patternStr.split("\\*");

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.length() < pattern[0].length() + pattern[1].length()) {
                System.out.println("NE");
                continue;
            }

            if (input.startsWith(pattern[0]) && input.endsWith(pattern[1])) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
