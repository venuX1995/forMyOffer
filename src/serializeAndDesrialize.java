public class serializeAndDesrialize {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    int index ;
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        if(str.equals("#,") || str==null)
            return null;
        String[] strArr = str.split(",");
        index = -1;
        return desirializeStr(strArr);
    }
    TreeNode desirializeStr(String[] strArr){
        index++;
        TreeNode newNode = null;
        if(index>strArr.length)
            return null;
        if(! strArr[index].equals("#")){
            newNode = new TreeNode(Integer.valueOf(strArr[index]));
            newNode.left = desirializeStr(strArr);
            newNode.right = desirializeStr(strArr);
        }
        return newNode;
    }
}
