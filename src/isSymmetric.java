public class isSymmetric {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root){
        return isSymmetricNode(root,root);
    }

    public boolean isSymmetricNode(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;

        return isSymmetricNode(t1.right,t2.left) && isSymmetricNode(t1.left,t2.right);
    }


}
