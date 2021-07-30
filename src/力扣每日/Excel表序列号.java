package 力扣每日;

/**
 * @author:yxl
 **/
public class Excel表序列号 {


    //给定表的序列 输出 列号  eg：ZY = 701
    public int titleToNumber(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
}
