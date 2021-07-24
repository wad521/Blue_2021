package 力扣每日;

/**
 * @author:yxl
 **/
public class 替换字符得到最晚时间 {
    public static void main(String[] args) {
        System.out.println(maximumTime("?4:03"));
    }
    static String maximumTime(String time) {
        char[] ch = time.toCharArray();
        if(ch[0]=='?'){
            ch[0]=(ch[1]>='4' && ch[1]<='9' ) ? '1' :'2' ;
        }
        if(ch[1]=='?'){
            ch[1] = ch[0]=='2' ? '3' :'9' ;
        }
        if(ch[3]=='?'){
            ch[3] ='5';
        }
        if(ch[4]=='?'){
            ch[4] = '9';
        }
        return new String(ch);
    }
}
