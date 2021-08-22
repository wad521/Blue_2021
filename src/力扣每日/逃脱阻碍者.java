package 力扣每日;

/**
 * @author:yxl
 **/
public class 逃脱阻碍者 {
    //只要存在着被逮到的情况 ， 均为无法逃脱


    //曼哈顿距离
    //范围【- 10^4 , 10^4】
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int min = Integer.MAX_VALUE;
        int mhd =juli(new int[]{0,0},target);

        for(int[] ghost : ghosts){
            min = Math.min(min,juli(ghost,target));
        if(min<=mhd)
            return false;
        }
        return true;
    }

    public int juli(int[] point , int[] tar){
        return Math.abs(point[0] - tar[0]) + Math.abs(point[1]-tar[1]);
    }
}
