package LeetCode_3月;

/**
 * @author:yxl
 **/
public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
        //标记第0列是否需要置零
        //matrix[0][0]标记第一行状态
        boolean col0_flag = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0)
                col0_flag = true;
            //当matris[i][0]为0时，可自认为第i行置零。所以j从1开始
            //若j从0开始，matrix[3][0]=0时，会把matrix[0][0]置0，扰乱第一行的标志位。
            for (int j = 1; j < col; j++) {
                //i行j列置零
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0_flag) {
                matrix[i][0] = 0;
            }
        }
    }
}
