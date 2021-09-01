package 力扣每日;

/**
 * @author:yxl
 **/
public class 比较版本号 {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\."), s2 = version2.split("\\.");

        int n = s1.length,m = s2.length;
        int i =0,j=0;
        while (i<n || j<m){
            int a=0,b=0;
            if(i<n){
                a = Integer.parseInt(s1[i]);i++;
            }
            if(j<m){
                b = Integer.parseInt(s2[j]);
                j++;
            }
            if(a!=b){
                return a>b?1:-1 ;
            }
        }
        return 0;
    }
}
