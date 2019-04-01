public class verifyBSTsequence {
    public boolean VerifyBSTsequence(int [] sequence) {
        if(sequence==null||sequence.length==0)
            return false;
        return verifyBSTsequence(sequence,0,sequence.length-1);
    }
    public boolean verifyBSTsequence(int[] sequence,int start,int end){
        boolean ans = true;
        if(start<end){
            int root = sequence[end];
            int i = start;
            for(;i<end;i++){
                if(sequence[i]>root)
                    break;
            }
            int j = i;
            for(;j<end;j++){
                if(sequence[j]<root)
                    return false;
            }
            boolean leftBST = true;
            if(start<i){
                leftBST = verifyBSTsequence(sequence,start,i-1);
            }
            boolean rightBST = true;
            if(i<end-1){
                rightBST = verifyBSTsequence(sequence,i,end-1);
            }
            ans = leftBST && rightBST;
        }
        return ans;
    }
}
