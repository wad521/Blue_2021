package 力扣每日;

/**
 * @author:yxl
 **/
public class 交替二进制数 {
    public boolean hasAlternatingBits(int n) {
        // 若为交替二进制数 n ^ (n>>1)  可得到  0000..11111这种形式
        int num = n ^ (n >> 1);
        // 将num+1得到  0000..100000形式
        // num & (num+1)必定成立
        if ((num & (num + 1)) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
