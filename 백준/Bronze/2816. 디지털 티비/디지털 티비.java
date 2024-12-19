import java.io.*;
import java.util.*;
public class Main {
    static String[] channels;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        channels = new String[N];

        // 채널 목록 입력
        for (int i = 0; i < N; i++) {
            channels[i] = br.readLine();
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (channels[i].equals("KBS1")) { // KBS1부터 첫번째로
                for (int j = i; j > 0; j--) {
                    result.append(4);
                    swap(j, j - 1);
                }
                break;
            } else {
                result.append(1);
            }
        }

        if (channels[1].equals("KBS2")) // KBS1을 첫번째로 옮기고 만약 KBS2가 두번째에 있다면 종료
            System.out.print(result);
        else {
            for (int i = 0; i < N; i++) {
                if (channels[i].equals("KBS2")) { // KBS2를 두번째로
                    for (int j = i; j > 1; j--) {
                        result.append(4);
                        swap(j, j - 1);
                    }
                    break;
                } else {
                    result.append(1);
                }
            }
            System.out.print(result);
        }
    }

    private static void swap(int a, int b) {
        String tmp = channels[a];
        channels[a] = channels[b];
        channels[b] = tmp;
    }
}
