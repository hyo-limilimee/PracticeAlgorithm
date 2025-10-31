import java.io.*;
import java.util.*;

public class Main {
    static int h, w;
    static int[] height;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        height = new int[w];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[w];
        int[] rightMax = new int[w];

        leftMax[0] = height[0];
        for (int i = 1; i < w; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[w - 1] = height[w - 1];
        for (int i = w - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0;
        for (int i = 0; i < w; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);

            if (minHeight > height[i]) {
                water += minHeight - height[i];
            }
        }
        System.out.println(water);
    }
}
