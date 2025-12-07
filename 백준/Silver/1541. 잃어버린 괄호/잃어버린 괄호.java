import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String[] splits = line.split("-");

        int result = 0;

        for (String num : splits[0].split("\\+")) {
            result += Integer.parseInt(num);
        }

        for (int i = 1; i < splits.length; i++) {
            int sum = 0;

            for (String num : splits[i].split("\\+")) {
                sum += Integer.parseInt(num);
            }
            result -= sum;
        }
        System.out.println(result);
    }
}
