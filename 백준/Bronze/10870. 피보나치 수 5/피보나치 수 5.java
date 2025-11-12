import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(n));
    }

    private static int fibo(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fibo(n-1) + fibo(n-2);
    }
}