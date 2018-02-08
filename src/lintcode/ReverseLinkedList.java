package lintcode;

public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
        this.next=null;
    }
}