import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 1;

        if (N == 0) {
            answer = 1;

        } else {
            for (int i = 1; i <= N; i++) {
                answer *= i;
            }
        }
        System.out.println(answer);
    }
}
