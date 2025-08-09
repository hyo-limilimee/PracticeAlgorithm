import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long answer = N -M;

        if(answer < 0){
            answer *= -1;
        }

        System.out.println(answer);
    }
}