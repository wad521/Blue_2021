package Hot_100;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 全排列 {
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 4};
        //参数x=0，表示从下标0开始全排列。

        AllPL(num, 0);
    }

    //交换num的i和j的值
    public static void swap(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }

    //全排列num数组的下标x及其以后所有元素的全排列
    //x前的元素全不动。
    public static void AllPL(int[] num, int x) {
        if (x == num.length) {
            //表示依次排列完成

            for (int i = 0; i < num.length; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();

            //返回上一层递归
            return;
        } else {
            for (int i = x; i < num.length; i++) {
                //交换一次数，表示一种排列可能性
                swap(num, x, i);
                //下标为x+1的元素进行递归排列
                AllPL(num, x + 1);
                //回溯，遍历下一种可能
                swap(num, x, i);
            }
        }
    }
}
