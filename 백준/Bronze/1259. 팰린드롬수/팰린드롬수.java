import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder(s);

            String rev = sb.reverse().toString();

            if (s.equals("0")) {
                break;
            }

            if (s.equals(rev)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
