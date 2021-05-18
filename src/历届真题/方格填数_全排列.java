package 历届真题;

/**
 * @author:yxl
 **/
public class 方格填数_全排列 {
    public static int count = 0;

    public static void main(String[] args) {
        //相当于排列问题
        int[] num = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        dfs(num, 0);
        System.out.println(count);
    }

    //判断当前排列是否满足条件。
    public static boolean check(int[] A) {
        if (Math.abs(A[0] - A[3]) != 1 && Math.abs(A[0] - A[4]) != 1 && Math.abs(A[0] - A[5]) != 1 && Math.abs(A[0] - A[1]) != 1) {
            if (Math.abs(A[1] - A[2]) != 1 && Math.abs(A[1] - A[4]) != 1 && Math.abs(A[1] - A[5]) != 1 && Math.abs(A[1] - A[6]) != 1) {
                if (Math.abs(A[2] - A[5]) != 1 && Math.abs(A[2] - A[6]) != 1) {
                    if (Math.abs(A[3] - A[4]) != 1 && Math.abs(A[3] - A[7]) != 1 && Math.abs(A[3] - A[8]) != 1) {
                        if (Math.abs(A[4] - A[7]) != 1 && Math.abs(A[4] - A[8]) != 1 && Math.abs(A[4] - A[9]) != 1 && Math.abs(A[4] - A[5]) != 1) {
                            if (Math.abs(A[5] - A[8]) != 1 && Math.abs(A[5] - A[9]) != 1 && Math.abs(A[5] - A[6]) != 1) {
                                if (Math.abs(A[6] - A[9]) != 1 && Math.abs(A[7] - A[8]) != 1) {
                                    if (Math.abs(A[8] - A[9]) != 1) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void swap(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }


    public static void dfs(int[] num, int x) {
        if (x == num.length) {
            if (check(num)) {
                count++;
            }
            return;
        } else {
            //交换当前字符与后序的字符，组成一种新的可能
            for (int i = x; i < num.length; i++) {
                swap(num, x, i);   //实现全排列  即交换字符位置
                dfs(num, x + 1);//后序元素的递归全排列
                swap(num, x, i);   //回溯
            }
        }
        return;
    }
}
