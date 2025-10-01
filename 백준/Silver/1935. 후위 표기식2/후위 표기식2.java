import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static double[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Stack<Double> stack = new Stack<>();
        arr = new double[N];

        for (int i = 0; i < N; i++) {
            double num = Double.parseDouble(br.readLine());
            arr[i] = num;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                stack.push(arr[ch - 'A']);

            } else {
                double a = stack.pop();
                double b = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(b + a);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(b * a);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
