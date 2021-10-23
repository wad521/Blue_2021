package 力扣每日;

/**
 * @author:yxl
 **/
public class 构造矩形 {
    public int[] constructRectangle(int area) {
        for (int i = (int)(Math.sqrt(area)); ;i--) {
            if (area % i == 0) return new int[]{area / i, i};
        }
    }
}
