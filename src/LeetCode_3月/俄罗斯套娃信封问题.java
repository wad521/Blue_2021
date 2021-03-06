package LeetCode_3月;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:yxl
 **/
public class 俄罗斯套娃信封问题 {
    public static void main(String[] args) {
        int[][] e = new int[][]{{1, 2}, {2, 4}, {3, 6},{5, 9}, {5, 8},  {5, 4}, {6, 10}};
        System.out.println(maxEnvelopes(e));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            for (int s : f) {
                System.out.print(s + "   ");
            }
            System.out.println();
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
