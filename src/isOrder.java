import java.util.Stack;
public class isOrder {
    private  static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(popA.length == 0 || pushA.length != popA.length)
            return false;
        int length = pushA.length;
        int pPush = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);
        for(int i=1;i<length;i++){
            if(stack.peek()!=popA[pPush]){
                stack.push(pushA[i]);
                continue;
            }else{
                while(!stack.isEmpty() && stack.peek()==popA[pPush]){
                    stack.pop();
                    pPush++;
                }
                stack.push(pushA[i]);
            }
        }
        while(!stack.isEmpty()&& pPush<length && stack.peek()==popA[pPush]){
            stack.pop();
            pPush++;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        int[] a = {1};
        int[] b = {1};
        boolean ans = IsPopOrder(a,b);
        System.out.println(ans);
    }
}
