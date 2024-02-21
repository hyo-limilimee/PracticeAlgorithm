import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int amount = Integer.parseInt(br.readLine());
        int[] coins = {500, 100, 50, 10, 5, 1};
        int count = 0;
        amount = 1000 - amount;

        for (int i = 0; i < coins.length; i++) {
            if (amount / coins[i] > 0) {
                count += amount / coins[i];
                amount = amount % coins[i];
            }
        }
        System.out.println(count);
    }
}
