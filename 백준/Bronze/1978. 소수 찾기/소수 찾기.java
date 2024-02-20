import java.io.*;
import java.util.*;

public class Main {

    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        st = new StringTokenizer(str);

        int count = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean isPrime = true;

            if (num == 1) {
                continue;
            }

            for (int j = 2; j < num; j++) {
                if(num % j == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                count++;
            }
        }
        System.out.println(count);
    }
}
