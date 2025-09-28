import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> numbers = new ArrayList<>();

        for (int t = 0; t < N; t++) {
            String str = br.readLine();
            StringBuilder num = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (Character.isDigit(c)) {
                    num.append(c);
                } else {
                    if (num.length() > 0) {
                        numbers.add(trimLeadingZeros(num.toString()));
                        num.setLength(0);
                    }
                }
            }
            if (num.length() > 0) {
                numbers.add(trimLeadingZeros(num.toString()));
            }
        }

        Collections.sort(numbers, (a, b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });

        StringBuilder sb = new StringBuilder();
        for (String n : numbers) {
            sb.append(n).append("\n");
        }
        System.out.print(sb);
    }

    private static String trimLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }
}
