public class KthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int count = 0;
    public TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null && k<=0)
            return null;
        TreeNode pNode = KthNode(pRoot.left,k);
        if(pNode!=null)
            return pNode;
        count++;
        if(count == k){
            return pRoot;
        }
        pNode = KthNode(pRoot.right,k);
        if(pNode!=null)
            return pNode;
        return null;
    }

}
