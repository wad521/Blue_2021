import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[][] re = new int[][]{{0,3},{0,4},{1,4},{2,1},{3,1}};
        System.out.println(removeStones(re));
    }
    public static int removeStones(int[][] stones) {
        UnionFind1 unionFind = new UnionFind1();

        for (int[] stone : stones) {
            //区分行和列
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - unionFind.getCount();
    }

    private static class UnionFind1 {

        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind1() {
           parent=new HashMap<>();
           count=0;
        }

        public int getCount() {
           return count;
        }

        public int find(int x) {
            //x是新节点，指向他自己
            if(!parent.containsKey(x)){
                parent.put(x,x);
                count++;
            }

            if(x!=parent.get(x)){
                //x的值不等于他的父节点的值，
                //x不是根节点的时候，将x的父节点设置为根节点
                //路径压缩
                parent.put(x,find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootx=find(x);
            int rooty=find(y);
            if(rootx==rooty){
                return;
            }
            //x和y不属于同一连通分量，
            parent.put(rootx,rooty);
            count--;
            System.out.println((x-10001)+"   "+y+"    :"+parent+ "   "+count);
        }


    }
}