import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] numbers = new String[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = br.readLine();
        }

        int L = numbers[0].length();

        for (int i = 1; i <= L; i++) {
            Set<String> seen = new HashSet<>();

            for (int j = 0; j < n; j++) {
                String suffix = numbers[j].substring(L - i);
                seen.add(suffix);
            }

            if (seen.size() == n) {
                System.out.println(i);
                return;
            }
        }
    }
}
