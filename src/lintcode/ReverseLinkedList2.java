package lintcode;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;
        ListNode nodeFront = null;


        for (int countM = 1; countM < m; countM++) {
            if (head == null) {
                return head;
            }
            head = head.next;
        }
        nodeFront = head;
        ListNode mNode = head.next; //Head is Mth node. Reserve it
        ListNode reversedList = mNode;
        ListNode postNode = mNode.next;
        for (int countN = m; countN < n; countN++) {
            ListNode temp = postNode.next;
            postNode.next = reversedList;
            reversedList = postNode;
            postNode = temp;
        }
        //List front, middle and end section
        nodeFront.next = reversedList;
        mNode.next = postNode;

        return dummyNode.next;
    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
        next=null;
    }
}