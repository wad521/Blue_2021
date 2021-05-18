
import java.util.Scanner;

public class Main {
    private static int count = 0;
    private static int[][] map;
    private static int n;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        map = new int[n][n];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                map[i][j] = input.nextInt();
            }
        }
        //0行开始放白皇后
        put(0, 2);
        System.out.println(count);
    }

    public static void put(int r, int s) {
        //r代表行 s=2 白皇后   s=3 黑皇后
        if (r == n) {
            //白皇后已放完
            if (s == 2) {
                //放置第一个黑皇后
                put(0, 3);
            } else {
                //可放置
                count++;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (map[r][i] != 1)
                continue;
            if(Pd(r,i,s)){
                map[r][i]=s;
                put(r+1,s);
                //当r行j列确定完后，回溯状态
                map[r][i]=1;
            }
        }
        return;
    }

    public static boolean Pd(int r, int j, int s) {
        //r行j列的位置放置s号皇后
        //同列
        for (int i = 0; i < r; i++) {
            if (map[i][j] == s)
                return false;
        }
        //主对角线
        for (int i = r - 1, t = j - 1; i >= 0 && t >= 0; i--, t--) {
            if (map[i][t] == s)
                return false;
        }
        for (int i = r - 1, t = j + 1; i >= 0 && t < n; i--, t++) {
            if (map[i][t] == s)
                return false;
        }
        return true;
    }

//    private static void printMap(){
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}


