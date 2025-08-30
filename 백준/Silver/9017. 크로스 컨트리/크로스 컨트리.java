import java.util.*;
import java.io.*;

public class Main {
    static int T, N;
    static int[] arr;
    static int[] teams;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            teams = new int[201];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                teams[arr[i]]++;
            }

            Map<Integer, List<Integer>> score = new HashMap<>();
            int currScore = 1;
            for (int i = 0; i < N; i++) {
                int x = arr[i];

                if (teams[x] != 6) continue;

                score.putIfAbsent(x, new ArrayList<>());
                score.get(x).add(currScore++);
            }

            int minSum = Integer.MAX_VALUE;
            int fifth = Integer.MAX_VALUE;
            int winner = -1;

            for (int team : score.keySet()) {
                List<Integer> scores = score.get(team);
                Collections.sort(scores);

                int sum = scores.get(0) + scores.get(1) + scores.get(2) + scores.get(3);

                if (sum == minSum) {
                    if (scores.get(4) < fifth) {
                        fifth = scores.get(4);
                        minSum = sum;
                        winner = team;
                    }
                }

                if (sum < minSum || (sum == minSum && scores.get(4) < fifth)) {
                    minSum = sum;
                    fifth = scores.get(4);
                    winner = team;
                }
            }
            System.out.println(winner);
        }
    }
}
