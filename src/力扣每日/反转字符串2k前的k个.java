package 力扣每日;

/**
 * @author:yxl
 **/
public class 反转字符串2k前的k个 {
    public static void main(String[] args) {

    }

    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i = i+2*k) {
            int j = i + k-1;
            reverse(ch,i,Math.min(j,n-1));
        }
        return new String(ch);
    }

    public static void reverse(char[] ch ,int i,int j){
        while (i<j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }
}
