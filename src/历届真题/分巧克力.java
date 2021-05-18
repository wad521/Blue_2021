package 历届真题;

import java.util.Scanner;

/**
 * @author:yxl
 **/
public class 分巧克力 {

    static class Chocolate {
        int x, y;

        public Chocolate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //N个巧克力  K个孩子
        int N = input.nextInt();
        int K = input.nextInt();
        int max = 0;
        Chocolate[] chocolates = new Chocolate[N];
        for (int i = 0; i < N; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            chocolates[i] = new Chocolate(x, y);
            int ex = x > y ? x : y;
            //max是所有巧克力的长宽里的最大值。
            max = max > ex ? max : ex;
        }
        input.close();
        int l = 1, r = max + 1;
        int ans = 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i = 0; i < N; i++) {
                count += ((chocolates[i].x / mid) * (chocolates[i].y / mid));
            }
            if (count >= K) {
                l = mid + 1;
                ans = mid;
            } else if (count < K) {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}













