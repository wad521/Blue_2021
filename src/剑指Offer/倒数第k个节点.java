package 力扣每日;

/**
 * @author:yxl
 **/
public class 倒数第k个节点 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //前后节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode low = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            low = low.next;
            fast = fast.next;
        }
        return low;
    }
}
