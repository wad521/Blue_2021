package 力扣每日;

/**
 * @author:yxl
 **/



public class 扁平化多级双向链表 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };


    public Node flatten(Node head) {
        if(head == null){
            return head;
        }

        Node dummy = new Node();
        dummy.next = head;
        while (head != null){
            if(head.child == null){
                head = head.next;
                //存在下级链表
            }else {
                //存在下级链表表示 head的child不为空；
                Node temp = head.next;
                Node second = flatten(head.child);
                head.next = second;
                second.prev = head;
                head.child = null;
                while (head.next!=null){
                    head = head.next;
                }

                //防止next为空，child不为空
                if(temp!=null){
                    head.next = temp;
                    temp.prev = head;
                    head = temp;
                }

            }
        }
        return dummy.next;
    }
}
