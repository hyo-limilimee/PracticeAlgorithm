import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 국가의 수
        int N = Integer.parseInt(st.nextToken());
        // 등수를 알고 싶은 국가
        int K = Integer.parseInt(st.nextToken());

        List<Nation> nations = new ArrayList<>();

        // 국가 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            nations.add(new Nation(num, gold, silver, bronze));
        }

        Collections.sort(nations);

        // 등수 계산
        int rank = 1;
        for (int i = 0; i < nations.size(); i++) {
            if (i > 0 && nations.get(i).compareTo(nations.get(i - 1)) != 0) {
                
                rank = i + 1;
            }
            nations.get(i).rank = rank;
        }

        for (Nation nation : nations) {
            if (nation.num == K) {
                System.out.println(nation.rank);
                break;
            }
        }
    }

    static class Nation implements Comparable<Nation> {
        int num, gold, silver, bronze, rank;

        Nation(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return Integer.compare(o.bronze, this.bronze);
                }
                return Integer.compare(o.silver, this.silver);
            }
            return Integer.compare(o.gold, this.gold);
        }
    }
}
