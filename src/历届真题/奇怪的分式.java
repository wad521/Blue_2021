package 历届真题;

/**
 * @author:yxl
 **/
public class 奇怪的分式 {
    static double[] ans = new double[4];
    static int result = 0;

    public static void main(String[] args) {
        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int k) {
        //一种可能遍历完
        if (k == 4) {
            if (check()) {
                result++;
            }
        } else {
            for (int i = 1; i < 10; i++) {
                ans[k] = i;
                dfs(k + 1);
            }
        }
    }

    public static boolean check() {
        if (ans[0] != ans[1] && ans[2] != ans[3]) {
            if (ans[0] * ans[2] * (ans[1] * 10 + ans[3]) == ans[1] * ans[3] * (ans[0] * 10 + ans[2])) {
                return true;
            }
        }
        return false;
    }
}
