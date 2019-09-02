import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class maxDepth {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            this.val = x;
        }
    }
    /*
    DFS 深度优先遍历
     */
//    public int maxDepth(TreeNode root){
//        if(root == null) return 0;
//
//        int leftDepth = maxDepth(root.left);
//        int rightDepth = maxDepth(root.right);
//
//        return Math.max(leftDepth,rightDepth)+1;
//    }
    /*
    BFS 广度优先遍历
     */
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int ans = 0;
        Deque<TreeNode> queue = new LinkedList();
        ((LinkedList) queue).add(root);

        while(!queue.isEmpty()){
            ans++;
            int n = queue.size();
            for(int i=0; i<n; i++){
                TreeNode temp = queue.poll();
                if(temp.left!=null) ((LinkedList<TreeNode>) queue).add(temp.left);
                if(temp.right!=null) ((LinkedList<TreeNode>) queue).add(temp.right);
            }
        }
        return ans;
    }
}
