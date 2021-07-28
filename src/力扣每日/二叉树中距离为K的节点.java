package 力扣每日;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:yxl
 **/
public class 二叉树中距离为K的节点 {
     Map<Integer,TreeNode> map = new HashMap<Integer,TreeNode>();
     ArrayList<Integer> list = new ArrayList<>();

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 从 root 出发 DFS，记录每个结点的父结点
        findparents(root);

        //从target开始dfs查找距离为k的节点
        findAns(target,null,0,k);

        return list;
    }

    public  void findparents(TreeNode node){
        if(node.left!=null){
            map.put(node.left.val,node);
            findparents(node.left);
        }

        if(node.right!=null){
            map.put(node.right.val,node);
            findparents(node.right);
        }

    }

    //node 当前节点  form：上一个遍历的节点  depth：已遍历深度  k：目标距离
    public  void findAns(TreeNode node,TreeNode form ,int depth,int k){
        if(node==null){
            return;
        }
        if(depth==k){
            list.add(node.val);
            return;
        }
        //如果当前node节点距离不足，遍历左子树 ||  （！=form防止向上遍历导致死循环）
        if(node.left!=form){
            findAns(node.left,node,depth+1,k);
        }

        //如果当前node节点距离不足，遍历右子树
        if(node.right!=form){
            findAns(node.right,node,depth+1,k);
        }

        //当前节点的左右子树全部遍历过，向上遍历  || map.get(node.val)!=form 防止向下遍历
        if(map.get(node.val)!=form){
            findAns(map.get(node.val),node,depth+1,k);
        }
    }
}
