package 历届真题;

/**
 * @author:yxl
 **/
public class 李白打酒 {
    static int ans = 0;

    public static void main(String[] args) {
        //因为最后一次遇见花
        dfs(5,9,2);
        System.out.println(ans);
    }

    //dian:还能遇见的店的数量
    //hua:还能遇见的花的数量
    //jiu:酒的余量
    public static void dfs(int dian, int hua, int jiu) {
        if (dian == 0 && hua == 0 && jiu == 1) {
            ans++;
            return;
        }
        //还能遇见店,则递归一次遇见店
        if (dian > 0) {
            dfs(dian - 1, hua, jiu * 2);
        }
        //还能遇见花，并且有酒
        if (hua > 0 && jiu > 0) {
            dfs(dian,hua-1,jiu-1);
        }
    }
}
