import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i = 0; i < N; i++){
           int tmp = Integer.parseInt(br.readLine());

           if(tmp == 0){
               if(pq.isEmpty()){
                   System.out.println("0");
               }
               else{
                   System.out.println(pq.poll());
               }
           }
           else{
               pq.add(tmp);
           }
        }
    }
}