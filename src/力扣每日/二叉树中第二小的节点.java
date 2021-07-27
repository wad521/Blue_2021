package 力扣每日;

/**
 * @author:yxl
 **/
public class 二叉树中第二小的节点 {
    //root.val = min(root.left.val, root.right.val) 总成立
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


        public int findSecondMinimumValue(TreeNode root) {
            if(root == null || root.left == null) return -1;
            int left = root.val == root.left.val ?
                    findSecondMinimumValue(root.left) :
                    root.left.val;
            int right = root.val == root.right.val ?
                    findSecondMinimumValue(root.right) :
                    root.right.val;
            int min = Math.min(left,right);
            return  min > 0 ? min : Math.max(left,right);
        }
}
