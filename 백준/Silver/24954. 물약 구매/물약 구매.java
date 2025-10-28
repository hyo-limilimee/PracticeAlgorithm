import java.io.*;
import java.util.*;

public class Main {
    static class Medicine {
        int cost;
        List<int[]> sales = new ArrayList<>();
        Medicine(int cost) {
            this.cost = cost;
        }
    }

    static int N;
    static List<Medicine> medicines;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        medicines = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cost = Integer.parseInt(st.nextToken());
            medicines.add(new Medicine(cost));
        }

        for (int i = 0; i < N; i++) {
            int saleCnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < saleCnt; j++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken()) - 1;
                int saleInfo = Integer.parseInt(st.nextToken());
                medicines.get(i).sales.add(new int[]{num, saleInfo});
            }
        }

        visited = new boolean[N];
        dfs(0, 0, new int[N]);
        System.out.println(answer);
    }

    static void dfs(int depth, int totalCost, int[] currentCosts) {
        if (depth == N) {
            if (totalCost < answer) {
                answer = totalCost;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            int price;
            if (currentCosts[i] == 0) {
                price = medicines.get(i).cost;
            } else {
                price = currentCosts[i];
            }

            visited[i] = true;
            int[] nextCosts = Arrays.copyOf(currentCosts, N);

            for (int[] sale : medicines.get(i).sales) {
                int target = sale[0];
                int discount = sale[1];
                int old;
                if (nextCosts[target] == 0) {
                    old = medicines.get(target).cost;
                } else {
                    old = nextCosts[target];
                }
                nextCosts[target] = old - discount;
                if (nextCosts[target] < 1) {
                    nextCosts[target] = 1;
                }
            }

            dfs(depth + 1, totalCost + price, nextCosts);
            visited[i] = false;
        }
    }
}
