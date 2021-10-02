package 力扣每日;

/**
 * @author:yxl
 **/
public class 数字转16进制 {
    //位运算 + 分组换算
    public String toHex(int num) {
        if(num ==0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (num!=0){
            int u = num &15;
            char ch = (char) (u+'0');
            if(u>=10){
               ch = (char)(u-10+'a');
            }
            sb.append(ch);
            num = num>>>4;
        }

        return sb.reverse().toString();
    }
}
