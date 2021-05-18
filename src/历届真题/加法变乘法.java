package 历届真题;

/**
 * @author:yxl
 **/
public class 加法变乘法 {
    public static void main(String[] args) {
        int ans = 0;

        //i和j为不相邻‘+’号左边的数
        for (int i = 1; i < 47; i++) {
            for (int j = i + 2; j < 49; j++) {
                ans = 1225 - (i + i + 1 + j + j + 1) + (i * (i + 1)) + (j * (j + 1));
                if (ans == 2015&&i!=10) {
                    System.out.println(i);
                }
            }
        }
    }
}
