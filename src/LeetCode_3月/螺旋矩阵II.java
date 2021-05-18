package LeetCode_3月;

/**
 * @author:yxl
 **/
public class 螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0, right = n - 1, bottom = n - 1, top = 0;
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = left; i <= right; i++)
                result[top][i] = num++;
            top++;
            for (int i = top; i <= bottom; i++)
                result[i][right] = num++;
            right--;
            for (int i = right; i >= left; i--)
                result[bottom][i] = num++;
            bottom--;
            for (int i = bottom; i >= top; i--)
                result[i][left] = num++;
            left++;
        }
        return result;
    }
}
//class Solution {
//    public int[][] generateMatrix(int n) {
//        int l = 0, r = n - 1, t = 0, b = n - 1;
//        int[][] mat = new int[n][n];
//        int num = 1, tar = n * n;
//        while(num <= tar){
//            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
//            t++;
//            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
//            r--;
//            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
//            b--;
//            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
//            l++;
//        }
//        return mat;
//    }
//}