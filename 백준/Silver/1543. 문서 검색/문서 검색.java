import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        String find = br.readLine();

        int index = 0;
        int count = 0;
        int len = find.length();
        while(index <= target.length() - len){
            String compare = target.substring(index, index + len);
            if(find.equals(compare)){
                index = index + len;
                count++;
            }else{
                index++;
            }
        }

        System.out.println(count);
    }
}
