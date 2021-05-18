package 历届真题;

/**
 * @author:yxl
 **/
public class 牌型种数 {
    static int count=0;
    public static void main(String[] args) {
        dfs(0,0);
        System.out.println(count);
    }

    //k已取过的牌的种类，一共已经取了n张
    public static void dfs(int k,int n){
        if(k>13||n>13){
            return;
        }
        //取够13张就可
        if(n==13){
            count++;
            return;
        }
        //递归第k+1张牌取i张
        for (int i = 0; i < 5; i++) {
            dfs(k+1,n+i);
        }
    }
}
