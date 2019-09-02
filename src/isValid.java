import java.util.Stack;

public class isValid {
    public boolean isValid(String s){
        if(s == null)
            return true;
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(temp=='(' || temp=='{' || temp=='['){
                stack.push(temp);
            }else if(stack.isEmpty()){
                return false;
            }else{
                char match = stack.pop();
                if((match=='(' && temp!=')') || (match=='{' && temp!='}') || (match=='[' && temp!=']'))
                    return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }

}
