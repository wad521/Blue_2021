package 国赛;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 排列数 {
    private static int k, n;

    private static long result = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        k = input.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
        }
        AllPL(num, 0);
        System.out.println(result);
    }


    public static boolean check(int[] num) {
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if ((num[i] > num[i - 1] && num[i] > num[i + 1]) || (num[i] < num[i - 1] && num[i] < num[i + 1])) {
                ans++;
            }
        }
        return ans + 1 == k;
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
            if(check(num)){
                result++;
            }
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
