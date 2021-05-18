package 历届真题;

/**
 * @author:yxl
 **/
public class 第39级台阶 {
    static int result = 0;

    public static void main(String[] args) {
        dfs(0, 0, 39);
        System.out.println(result);
    }


    //步数和 ， 已经走过的台阶数
    public static void dfs(int bushu, int floor, int high) {
        if (floor > high) {
            return;
        }
        if (floor == high && bushu % 2 == 0) {
            result++;
            return;
        }
        dfs(bushu + 1, floor + 1, high);
        dfs(bushu + 1, floor + 2, high);
    }
}
