package 历届真题;

import java.security.PublicKey;

/**
 * @author:yxl
 **/
public class 质数拆分 {

    public static long count = 0;
    public static int tol = 0;

    public static void main(String[] args) {
        int[] num = new int[2019];

        boolean[] visit = new boolean[2020];
        for (int i = 2; i <= 2019; i++) {
            if (visit[i] == true) {
                continue;
            }
            num[tol++] = i;
            for (int j = i + i; j <= 2019; j += i) {
                visit[j] = true;
            }
        }
        for (int i = 0; i < tol; i++) {
            System.out.println(num[i]);
        }
        dfs(0,num,0);
        System.out.println(count);
    }


    public static void dfs(int value, int[] num, int i) {
        if(value>2019){
            return;
        }else if (value == 2019) {
            count++;
            return;
        }
        //下一个数存在与否
        if(i< tol){
            //第i个数要
            dfs(value + num[i], num, i + 1);
            //第i个数不要
            dfs(value, num, i + 1);
        }
    }
}
