import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());

        BigInteger min = a.min(b);
        BigInteger max = a.max(b);

        BigInteger n = max.subtract(min).add(BigInteger.ONE);
        BigInteger s = min.add(max);

        BigInteger two = BigInteger.valueOf(2);
        if (n.mod(two).equals(BigInteger.ZERO)) {
            n = n.divide(two);
        } else {
            s = s.divide(two);
        }

        System.out.print(n.multiply(s));
    }
}
