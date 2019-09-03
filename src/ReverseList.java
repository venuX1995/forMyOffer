public class ReverseList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode pPre = null;
        ListNode pNow = head;
        ListNode pNext = head.next;

        while(pNext != null){
            pNow.next = pPre;
            pPre = pNow;
            pNow = pNext;
            pNext = pNext.next;
        }

        pNow.next = pPre;
        return pNow;
    }
}
