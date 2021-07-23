package 剑指Offer;

/**
 * @author:yxl
 **/
public class 差分数组前缀和判断覆盖范围 {
    public static void main(String[] args) {
        int[][] ranges = new int[][]{{1,2},{3,4},{5,6}};
        System.out.println(isCovered(ranges,2,5));
    }

    //范围固定在【0,50】之间
    static boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for(int[] range : ranges){
            diff[range[0]]++;
            diff[range[1]+1]--;
        }
        int[] sum = new int[52];
        for (int i = 1; i < 52; i++) {
            sum[i] = sum[i-1]+diff[i];
        }
        for (int i = left; i <= right ; i++) {
            if(sum[i]<=0){
                return false;
            }
        }
        return true;
    }
}
