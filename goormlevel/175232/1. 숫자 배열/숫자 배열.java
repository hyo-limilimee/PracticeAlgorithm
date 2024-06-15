import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N * N; i++){		
			if((i+1) % N == 0){
				System.out.println(i+1);
			}else{
				System.out.print(i+1 + " ");
			}
		}
	}
}