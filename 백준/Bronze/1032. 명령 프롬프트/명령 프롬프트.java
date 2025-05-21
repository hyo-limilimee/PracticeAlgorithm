import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] names = new String[N];

        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }

        int length = names[0].length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            boolean flag = true;

            for(int j = 1; j < N; j++){
                if(names[j].charAt(i) != names[j-1].charAt(i)){
                    flag = false;
                    break;
                }
            }

            if(flag){
                sb.append(names[0].charAt(i));
            }else{
                sb.append("?");
            }
        }
        System.out.println(sb);
    }
}
