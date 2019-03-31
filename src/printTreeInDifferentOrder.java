import java.util.ArrayList;
import java.util.Stack;

public class printTreeInDifferentOrder {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList ans = new ArrayList();
        if(pRoot == null)
            return ans;
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        s1.add(pRoot);
        while(!s1.isEmpty()||!s2.isEmpty()){
            if(!s1.isEmpty()){
                ArrayList<Integer> subAns = new ArrayList<Integer>();
                while(!s1.isEmpty()){
                    TreeNode temp = s1.pop();
                    subAns.add(temp.val);
                    s2.add(temp.right);
                    s2.add(temp.left);
                }
                ans.add(subAns);
            }
            if(!s2.isEmpty()){
                ArrayList<Integer> subAns = new ArrayList<Integer>();
                while(!s2.isEmpty()){
                    TreeNode temp = s2.pop();
                    subAns.add(temp.val);
                    s1.add(temp.left);
                    s1.add(temp.right);
                }
                ans.add(subAns);
            }
        }
        return ans;
    }

}
