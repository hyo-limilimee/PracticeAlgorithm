import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            
            if (line.equals("#")) {
                break;
            }

            int count = 0;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    count++;
                }
            }
            System.out.println(count);
        }
        
        sc.close();
    }
}