package LeetCode_3月;

/**
 * @author:yxl
 **/
public class _3_3 {
    public int[] countBits(int num) {
        int[] n = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if (i % 2 == 0) {
                n[i] = n[i / 2];
            } else {
                n[i] = n[i - 1] + 1;
            }
        }
        return n;
    }
}

