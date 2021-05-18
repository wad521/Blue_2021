package 算法训练;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 用二分法查找 {
    static int num;
    static int[] data;

    public static void main(String[] args) {
        data = new int[200];
        //等同于已排好序的升序数组
        for (int i = 0; i < 200; i++) {
            data[i] = 4 * i + 6;
        }
        Scanner input = new Scanner(System.in);
        int left = 0, right = 199;
        num = input.nextInt();
        System.out.println(find(left, right));

    }

    public static int find(int left, int rigth) {
        int mid = (left + rigth) / 2;
        if (num == data[mid]) {
            return mid;
        } else if (num > data[mid]) {
            return find(mid + 1, rigth);
        } else {
            return find(left, mid);
        }
    }
}
