package lintcode;

public class ReverseLinkedList {
    public ListNode1 reverse(ListNode1 head) {
        // write your code here
        ListNode1 pre=null;
        ListNode1 cur=head;
        while(cur!=null){
            ListNode1 next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
class ListNode1{
    int val;
    ListNode1 next;
    public ListNode1(int val){
        this.val=val;
        this.next=null;
    }
}