public class cloneRandomListNode {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        RandomListNode pCur = pHead;
        while(pCur!=null){       //在原链表的每个节点后面复制新的节点
            RandomListNode pClone = new RandomListNode(pCur.label);
            pClone.next = pCur.next;
            pCur.next = pClone;
            pCur = pClone.next;
        }
        pCur = pHead;
        while(pCur!=null){
            pCur.next.random = pCur.random==null?null:pCur.random.next;
            pCur = pCur.next.next;
        }
        pCur = pHead;
        RandomListNode pCloneHead = pHead.next;
        RandomListNode pNewHead =pCloneHead;
        while (pCur!=null){
            pCur.next = pNewHead.next;
            pCur = pCur.next;
            pNewHead.next = pCur==null?null:pCur.next;
            pNewHead = pNewHead.next;
        }
        return pCloneHead;
    }

}
