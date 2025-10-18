import java.io.*;
import java.util.*;

public class Main {
    static int[] alphabets = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int len = A.length();
        int[] arr = new int[len * 2];

        for (int i = 0; i < len; i++) {
            arr[i * 2] = alphabets[A.charAt(i) - 'A'];
            arr[i * 2 + 1] = alphabets[B.charAt(i) - 'A'];
        }

        int size = len * 2;
        while (size > 2) {
            int[] next = new int[size - 1];
            for (int i = 0; i < size - 1; i++) {
                next[i] = (arr[i] + arr[i + 1]) % 10;
            }
            arr = next;
            size--;
        }
        System.out.println("" + arr[0] + arr[1]);
    }
}
