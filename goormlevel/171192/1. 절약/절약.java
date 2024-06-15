import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Integer.parseInt(br.readLine());
		long money = 0;
		Boolean result = true;
		
		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String c = st.nextToken();
			int v = Integer.parseInt(st.nextToken());
			
			if(c.equals("in")){
				money += v;
			}
			else if(c.equals("out")){
				money -= v;
			}
		
			if(money < 0){
				result = false;
			}
		}
		if(result == true){
			System.out.println("success");
		}
		else{
			System.out.println("fail");
		}
	}
}