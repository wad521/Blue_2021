package 力扣每日;

/**
 * @author:yxl
 **/
public class 删除相邻颜色块 {
    public static void main(String[] args) {

    }

    //Alice 可以选择删除的位置是连续的 'A' 中的中间部分，即 A...AA
    //Bob 可以选择删除的位置是连续的 'B' 中的中间部分，即 B...BB
    //记录格子的操作数，谁多谁胜利
    public boolean winnerOfGame(String colors) {
        char[] cs = colors.toCharArray();
        int n = cs.length;
        int a = 0, b = 0;
        for (int i = 1; i < n - 1; i++) {
            if (cs[i] == 'A' && cs[i - 1] == 'A' && cs[i + 1] == 'A') a++;
            if (cs[i] == 'B' && cs[i - 1] == 'B' && cs[i + 1] == 'B') b++;
        }
        return a > b;
    }

}
