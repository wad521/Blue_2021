package LeetCode_3月;

import java.util.*;

/**
 * @author:yxl
 **/
public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null && matrix.length == 0 && matrix[0].length == 0) {
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        //旋转层数:count
        int count = (Math.min(m, n) + 1) / 2;
        //螺旋第i层
        while (i < count) {
            //左到右
            for (int j = i; j < n - i; j++) {
                list.add(matrix[i][j]);
            }
            //上到下
            for (int j = i + 1; j < m - i; j++) {
                list.add(matrix[j][n - 1 - i]);
            }
            //右到左,(m - 1 - i) != i 避免该层只有一行的情况
            for (int j = (n - 1) - (i + 1); j >= i && ((m - 1 - i) != i); j--) {
                list.add(matrix[m - i - 1][j]);
            }
            for (int j = (m - 1) - (i + 1); j >= i+1 && (n - 1 - i != i); j--) {
                list.add(matrix[j][i]);
            }
            i++;
        }
        return list;
    }
}
