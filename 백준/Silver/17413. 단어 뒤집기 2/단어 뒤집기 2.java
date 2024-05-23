import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean check = false;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == '<') {
                check = true;
                sb.append(temp.reverse());
                sb.append(c);
                temp = new StringBuilder();
            }
            else if(c == '>') {
                check = false;
                sb.append(temp);
                sb.append(c);
                temp = new StringBuilder();
            }
            else if(c == ' '){
                if(check){
                    sb.append(temp);
                    sb.append(c);
                    temp = new StringBuilder();
                }
                else{
                    sb.append(temp.reverse());
                    sb.append(c);
                    temp = new StringBuilder();
                }
            }
            else{
                temp.append(c);
            }
        }

        if(!temp.equals(" ")){
            sb.append(temp.reverse());
        }

        System.out.println(sb);
    }
}
