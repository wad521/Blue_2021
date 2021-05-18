package 历届真题;

/**
 * @author:yxl
 **/
public class 抽签 {
    /* 参数的含义：
     * a 数组a每个国家可以派出的最多的名额
     * k 从第k个国家选人
     * n 代表人数，初始为5
     * s 字符串
     */

    static int cnt;//用于计数，检验答案是否正确

    public static void f(int[] a, int k, int n, String s) {
        if (k == a.length) {
            if (n == 0) {
                System.out.println(s);
                cnt++;
            }
            return;
        }

        String s2 = s;
        for (int i = 0; i <= a[k]; i++) {                //试着将k国家派出i人
            //_____________________________;   //填空位置
            f(a, k + 1, n - i, s2);//填空位置    n-i表示剩余可派出的人数。
            s2 += (char) (k + 'A');
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 2, 1, 1, 3};        //数组a[] 中即是每个国家可以派出的最多的名额。
        f(a, 0, 5, "");
        System.out.println(cnt);
    }

}

