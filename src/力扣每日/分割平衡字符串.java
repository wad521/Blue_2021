package 力扣每日;

/**
 * @author:yxl
 **/
public class 分割平衡字符串 {
    public int balancedStringSplit(String s) {
        int n =s.length();
        char[] ch =s.toCharArray();
        int flag =0,ans=0;
        for (int i = 0; i < n; i++) {
            if(ch[i] == 'L'){
                flag++;
            }
            if(ch[i] == 'R'){
                flag--;
            }
            if(flag==0){
                ans++;
            }
        }
        return ans;
    }
}
