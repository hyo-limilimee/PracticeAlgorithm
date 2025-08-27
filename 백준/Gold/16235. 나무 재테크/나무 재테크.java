import java.io.*;
import java.util.*;

public class Main {

    static class Tree {
        int age;
        int r;
        int c;

        Tree(int age, int r, int c) {
            this.age = age;
            this.r = r;
            this.c = c;
        }
    }

    static class Field {
        int soil;
        List<Tree> trees;

        Field() {
            this.soil = 5;
            this.trees = new ArrayList<>();
        }

        void sort() {
            trees.sort(Comparator.comparingInt(t -> t.age));
        }
    }

    static int N, M, K;
    static int[][] A;
    static Field[][] fields;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static List<Tree> dead;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        fields = new Field[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                fields[i][j] = new Field();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            fields[x][y].trees.add(new Tree(z, x, y));
        }

        for (int i = 0; i < K; i++) {
            spring();
            summer();
            fall();
            winter();
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                answer += fields[i][j].trees.size();
            }
        }
        System.out.println(answer);
    }

    static void spring() {
        dead = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                fields[i][j].sort();

                for (int k = 0; k < fields[i][j].trees.size(); k++) {
                    int age = fields[i][j].trees.get(k).age;

                    if (fields[i][j].soil < age) {
                        deadTees(k, i, j);
                        break;
                    } else {
                        fields[i][j].soil -= age;
                        fields[i][j].trees.get(k).age++;
                    }
                }
            }
        }
    }

    static void deadTees(int k, int i, int j) {
        List<Tree> list = fields[i][j].trees;
        for (int idx = k; idx < list.size(); idx++) {
            int age = list.get(idx).age;
            dead.add(new Tree(age, i, j));
        }

        list.subList(k, list.size()).clear();
    }


    static void summer() {
        for (Tree d : dead) {
            int age = d.age;
            fields[d.r][d.c].soil += (age / 2);
        }
        dead.clear();
    }

    static void fall() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (Tree tree : fields[i][j].trees) {
                    if (tree.age % 5 == 0) {
                        for (int dir = 0; dir < 8; dir++) {
                            int nx = i + dx[dir];
                            int ny = j + dy[dir];

                            if (nx >= 1 && ny >= 1 && nx <= N && ny <= N) {
                                fields[nx][ny].trees.add(new Tree(1, nx, ny));
                            }
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                fields[i][j].soil += A[i][j];
            }
        }
    }
}
