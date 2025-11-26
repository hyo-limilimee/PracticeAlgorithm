import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int b1 = Integer.parseInt(br.readLine());
        int b2 = Integer.parseInt(br.readLine());
        int b3 = Integer.parseInt(br.readLine());
        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());

        int minBurger = Math.min(b1, Math.min(b2, b3));
        int minDrink = Math.min(d1, d2);

        System.out.println(minBurger + minDrink - 50);
    }
}
