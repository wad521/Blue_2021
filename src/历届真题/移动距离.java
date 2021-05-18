package 历届真题;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 移动距离 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int w = input.nextInt();
        int m = input.nextInt();
        int n = input.nextInt();
        int q1[] = find(m, w);
        int q2[] = find(n, w);
        //坐标
        System.out.println(q1[0] + " " + q1[1] + "    " + q2[0] + " " + q2[1]);
        System.out.println(dc(q1, q2));
    }

    //求行列下标
    public static int[] find(int idx, int w) {
        int[] mp = new int[2];
        //行号
        mp[0] = (idx - 1) / w;
        //偶数行
        if (mp[0] % 2 == 0) {
            int y1 = (idx - 1) % w;
            mp[1] = y1;
        } else {
            int y1 = (w - 1 - (idx - 1) % w);
            mp[1] = y1;
        }
        return mp;
    }

    public static int dc(int[] q1, int[] q2) {
        return Math.abs(q1[0] - q2[0]) + Math.abs(q1[1] - q2[1]);
    }
}
