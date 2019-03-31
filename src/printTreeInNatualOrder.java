import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class printTreeInNatualOrder {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null)
            throw new RuntimeException("invalid input");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList ans = new ArrayList();
        queue.add(root);
        TreeNode temp = root;
        while(temp!=null){
            ans.add(temp.val);
            if(temp.left!=null)
                queue.offer(temp.left);
            if(temp.right!=null)
                queue.offer(temp.right);
            temp = queue.poll();
        }
        return ans;
    }
}
