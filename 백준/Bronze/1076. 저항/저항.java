import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        Map<String, Integer> value = new HashMap<>();
        value.put("black", 0);
        value.put("brown", 1);
        value.put("red", 2);
        value.put("orange", 3);
        value.put("yellow", 4);
        value.put("green", 5);
        value.put("blue", 6);
        value.put("violet", 7);
        value.put("grey", 8);
        value.put("white", 9);

        long first = value.get(a);
        long second = value.get(b);
        long mul = (long) Math.pow(10, value.get(c));

        long result = (first * 10 + second) * mul;
        System.out.println(result);
    }
}
