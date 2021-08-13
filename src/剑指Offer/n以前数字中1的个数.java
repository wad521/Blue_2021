package 剑指Offer;

/**
 * @author:yxl
 **/

//找规律
    //https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
    //
    //

public class n以前数字中1的个数 {
    public static void main(String[] args) {
        int n = 32104 ;
        System.out.println(countDigitOne(n));
    }



    public static int countDigitOne(int n) {
        //dight位因子   cur 当前位的值 high：高位 low：低位
        int dight =1,res =0;
        int high = n /10 , cur = n%10 , low =0;
        while (high!=0 || cur != 0){
            if (cur == 0){
                res += (high * dight);
            }else if(cur == 1){
                res += (high * dight) + low + 1;
            }else{
                res += ((high + 1) * dight);
            }
            low += cur * dight ;
            dight = dight *10;
            cur = high % 10;
            high = high /10;
        }
        return res;
    }
}
