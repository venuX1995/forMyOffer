public class convertTreeToBiList {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }
    TreeNode pLast = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        if(pRootOfTree.left==null && pRootOfTree.right==null){
            pLast = pRootOfTree;
            return pRootOfTree;}
        TreeNode pHead = Convert(pRootOfTree.left);
        if(pHead!=null){
            pLast.right = pRootOfTree;
            pRootOfTree.left = pLast;
        }
        pLast = pRootOfTree;
        TreeNode right = Convert(pRootOfTree.right);
        if(right!=null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return pHead!=null?pHead:pRootOfTree;
    }
}
