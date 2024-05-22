import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int cntWhite;
    static int cntBlue;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cntWhite = 0;
        cntBlue = 0;

        divide(0, 0, N);

        System.out.println(cntWhite);
        System.out.println(cntBlue);
    }

    public static void divide(int x, int y, int size) {

        if(isPossible(x,y,size)){
            if(arr[x][y] == 1){
                cntBlue++;
            }
            else{
                cntWhite++;
            }
            return;
        }

        size /= 2;

        divide(x,y,size);
        divide(x,y+size,size);
        divide(x+size,y,size);
        divide(x+size,y+size, size);

    }

    public static boolean isPossible(int x, int y, int size) {
        int value = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(value != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
