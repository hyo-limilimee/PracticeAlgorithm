import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 포켓몬 수
        int N = Integer.parseInt(st.nextToken());
        // 문제 수
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> numToName = new HashMap<>();
        Map<String, Integer> nameToNum = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            numToName.put(i, name);
            nameToNum.put(name, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (Character.isDigit(input.charAt(0))) {
                sb.append(numToName.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(nameToNum.get(input)).append("\n");
            }
        }
        System.out.println(sb);
    }
}