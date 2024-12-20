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

        nations.sort((a, b) -> {
            if (a.gold != b.gold) return b.gold - a.gold;
            if (a.silver != b.silver) return b.silver - a.silver;
            return b.bronze - a.bronze;
        });

        Nation target = nations.get(K - 1);

        // 등수를 계산
        int rank = 1;
        for (int i = 0; i < nations.size(); i++) {
            if (nations.get(i).equals(target)) {
                rank = i + 1;
                break;
            }
        }

        System.out.println(rank);
    }

    static class Nation {
        int num, gold, silver, bronze;

        Nation(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Nation nation = (Nation) obj;
            return gold == nation.gold && silver == nation.silver && bronze == nation.bronze;
        }

        @Override
        public int hashCode() {
            return Objects.hash(gold, silver, bronze);
        }

        @Override
        public String toString() {
            return "Nation{num=" + num + ", gold=" + gold + ", silver=" + silver + ", bronze=" + bronze + "}";
        }
    }
}
