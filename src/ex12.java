import java.util.Scanner;

/*
 * 2n皇后
 *  白皇后是2，黑皇后是3
 */
public class ex12{
    private static int count = 0;
    private static int n;
    private static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        put(0, 2);// 第一个参数表示行，第二个参数表示皇后
        System.out.println(count);
    }

    private static void put(int r, int s) {
        // TODO Auto-generated method stub
        if (r == n) {// 表示已经放到最后一行了
            if (s == 2) { // 说明放的是白皇后，该放黑皇后了
                put(0, 3);
            } else {
                count++;
            }
            return;
        }
        // 开始按行放皇后
        for (int i = 0; i < n; i++) {
            if (map[r][i] != 1) // 不是1不能放
                continue;
            if (check(r, i, s)) {
                map[r][i] = s;
//              printMap();
                put(r+1, s);    //特别注意这里是r+1不能是r++，本人在这踩了个坑
                map[r][i] = 1;  //回溯的关键
            }
        }
        return ;
    }

    // 检查是否能放皇后
    private static boolean check(int r, int i, int s) {

        for (int j = 0; j < r; j++) { // 检查同列
            if (map[j][i] == s)
                return false;
        }
        // 检查主对角线，只往上检查，下面的还没放
        for (int j = r - 1, t = i - 1; j >= 0 && t >= 0; j--, t--) {
            if (map[j][t] == s) {
                return false;
            }
        }
        // 检查次对角线，只往上检查
        for (int j = r - 1, t = i + 1; j >= 0 && t < n; j--, t++) {
            if (map[j][t] == s) {
                return false;
            }
        }
        return true;
    }
    //打印地图
    private static void printMap(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
