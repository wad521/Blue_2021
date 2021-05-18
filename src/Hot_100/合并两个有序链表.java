package Hot_100;

/**
 * @author:yxl
 **/
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //prehead 始终指向头
        ListNode prehead = new ListNode(-1);
        //pre始终指向当前
        ListNode pre = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        //当上述循环做完后 还剩一条未合并完。
        pre.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}