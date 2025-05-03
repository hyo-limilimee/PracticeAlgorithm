import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int[] alphabets = new int[26];
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char c = Character.toLowerCase(str.charAt(j));

                if (c >= 'a' && c <= 'z') {
                    int index = c - 'a';
                    alphabets[index]++;
                }
            }

            int min = Integer.MAX_VALUE;
            for (int cnt : alphabets) {
                min = Math.min(min, cnt);
            }

            sb.append("Case ").append(i + 1).append(": ");
            if (min >= 3) sb.append("Triple pangram!!!");
            else if (min == 2) sb.append("Double pangram!!");
            else if (min == 1) sb.append("Pangram!");
            else sb.append("Not a pangram");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
