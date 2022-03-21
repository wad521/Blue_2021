package 力扣每日;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author:yxl
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 *
 **/
public class BST的两数之和 {
   public class TreeNode {
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

        public boolean findTarget(TreeNode root, int k) {
            Deque<TreeNode> ld = new ArrayDeque<>(), rd = new ArrayDeque<>();
            TreeNode temp = root;
            while (temp != null) {
                ld.addLast(temp);
                temp = temp.left;
            }
            temp = root;
            while (temp != null) {
                rd.addLast(temp);
                temp = temp.right;
            }
            TreeNode l = ld.peekLast(), r = rd.peekLast();
            while (l.val < r.val) {
                int t = l.val + r.val;
                if (t == k) return true;
                if (t < k) l = getNext(ld, true);
                else r = getNext(rd, false);
            }
            return false;
        }


        TreeNode getNext(Deque<TreeNode> d, boolean isLeft) {
            TreeNode node = isLeft ? d.pollLast().right : d.pollLast().left;
            while (node != null) {
                d.addLast(node);
                node = isLeft ? node.left : node.right;
            }
            return d.peekLast();
        }

    }
}
