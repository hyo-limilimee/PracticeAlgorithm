import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String expStr = br.readLine();

        Stack<Character> stack = new Stack<>();
        int expLen = expStr.length();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= expLen) {
                boolean isExplosion = true;

                for (int j = 0; j < expLen; j++) {
                    if (stack.get(stack.size() - expLen + j) != expStr.charAt(j)) {
                        isExplosion = false;
                        break;
                    }
                }

                if (isExplosion) {
                    for (int j = 0; j < expLen; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.empty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
