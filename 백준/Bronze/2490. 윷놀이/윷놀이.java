import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int zeroCount = 0;

            for(int j = 0; j < 4; j++){
                int x = Integer.parseInt(st.nextToken());
                if(x == 0) zeroCount++;
            }

            switch(zeroCount){
                case 1: 
                    System.out.println("A"); 
                    break;
                case 2: 
                    System.out.println("B"); 
                    break;
                case 3: 
                    System.out.println("C"); 
                    break;
                case 4: 
                    System.out.println("D"); 
                    break;
                case 0: 
                    System.out.println("E"); 
                    break;
            }
        }
    }
}
