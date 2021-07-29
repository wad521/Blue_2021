package 力扣每日;

import java.util.*;

/**
 * @author:yxl
 **/
public class 二叉树寻路 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        int lv = 0, temp = label;
        while (temp > 0) {
            ++lv;
            temp /= 2;
        }
        System.out.println(lv);
        while (true) {
            res.add(0, label);
            if (label == 1) {
                break;
            }
            int start = (int) Math.pow(2, lv - 2), cnt = start, end = start + cnt - 1;
            double mid = (start + end) / 2.0;
            double parent = (double) (label / 2);
            double diff = Math.abs(parent - mid);
            label = parent > mid ? (int) (mid - diff) : (int) (mid + diff);
            --lv;
        }

        return res;
    }
}
