import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger n = sc.nextBigInteger(); // 돈의 개수
        BigInteger m = sc.nextBigInteger(); // 사람 수

        // 몫
        System.out.println(n.divide(m));
        // 나머지
        System.out.println(n.remainder(m));

        sc.close();
    }
}
