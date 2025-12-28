import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> serials = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String serial = br.readLine();
            serials.add(serial);
        }

        Collections.sort(serials, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }

            int sumA = digitSum(a);
            int sumB = digitSum(b);

            if (sumA != sumB) {
                return sumA - sumB;
            }

            return a.compareTo(b);
        });

        for (String str : serials) System.out.println(str);
    }

    private static int digitSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sum += (c - '0');
            }
        }
        return sum;
    }
}
