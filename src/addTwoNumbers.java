public class addTwoNumbers {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode ans = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = ans;
        int addOneOrNot = 0;
        while(p1 != null || p2 != null){
            int val1 = (p1!=null)? p1.val : 0;
            int val2 = (p2!=null)? p2.val : 0;
            int sum = val1 + val2 + addOneOrNot;
            addOneOrNot = 0;
            if(sum>=10){
                addOneOrNot = 1;
                p3.next = new ListNode(addOneOrNot-10);
            }else{
                p3.next = new ListNode(sum);
            }
            p3 = p3.next;
            if (p1!=null) p1=p1.next;
            if (p2!=null) p2=p2.next;
        }
        if(addOneOrNot >0){
            p3.next = new ListNode(addOneOrNot);
        }
        return ans.next;
    }
}
