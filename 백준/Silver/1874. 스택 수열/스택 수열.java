import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        int start = 0;

        // n개의 숫자에 대해서 반복
        for (int i = 0; i < n; i++) {
            // 숫자 불러오기
            int x = Integer.parseInt(br.readLine());

            if(x > start) {
                for (int j = start + 1; j <= x; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                start = x;
            }

            // 불가능한 경우
            else if(stack.peek()!=x){
                System.out.println("NO");
                return;
            }

                stack.pop();
                sb.append('-').append('\n');

        }
        System.out.println(sb);
    }
}
