package 力扣每日;

/**
 * @author:yxl
 **/
public class 最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        int j =s.length()-1;
        while (j>=0&&s.charAt(j)==' ') j--;
        int i =j;
        while (i>=0&&s.charAt(i)!=' ') i--;
        return j-i;
    }
}
