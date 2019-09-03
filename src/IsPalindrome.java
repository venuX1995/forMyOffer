public class IsPalindrome {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null)
            return true;
        //双指针遍历链表，定位链表中点;同时反转链表前半节
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pPre = null , pPrePre = null;

        while(fast != null && fast.next != null){
            pPre = slow;
            slow = slow.next;
            fast = fast.next.next;

            pPre.next = pPrePre;
            pPrePre = pPre;
        }

        ListNode p1;
        ListNode p2 = slow.next;
        if(fast != null){
            //链表长度为偶数
            p1 = slow;
            slow.next = pPre;
        }else{
            //链表长度为单数
            p1 = pPre;
        }

        //比较两个链表的异同
        while (p1!=null){
            if(p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
}
