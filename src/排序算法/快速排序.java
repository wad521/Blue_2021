package 排序算法;

import java.util.Arrays;

/**
 * @author:yxl
 **/
public class 快速排序 {
    public static void main(String[] args) {

        int[] a = new int[]{12, 10, 23, 5, 3, 9, 16, 11, 8};
        int len = a.length;

        quick_sort(a, 0, len - 1);

        System.out.println(Arrays.toString(a));
    }

    private static void quick_sort(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int x = arr[l];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (arr[i] < x);
            do {
                j--;
            } while (arr[j] > x);

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        quick_sort(arr, l, j);
        quick_sort(arr, j + 1, r);
    }
}
