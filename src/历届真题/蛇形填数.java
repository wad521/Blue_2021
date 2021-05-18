package 历届真题;

/**
 * @author:yxl
 **/
public class 蛇形填数 {
    public static void main(String[] args) {
        int[][] num = new int[40][40];
        int cur = 1;
        for (int i = 1; i < 40; i++) {
            //奇数斜行
            if (cur % 2 == 1) {
                for (int x = i, y = 1; x >= 1 && y <= i; x--, y++) {
                    num[x][y] = cur++;
                }
            } else {
                for (int x = 1, y = i; x <= i && y >= 1;x++,y--){
                    num[x][y]=cur++;
                }
            }
        }
        System.out.println(num[20][20]);
    }
}
