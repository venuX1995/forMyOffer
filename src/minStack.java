import java.util.Stack;
public class minStack {
    Stack<Integer> minStack = new Stack();
    Stack<Integer> myStack = new Stack();
    public void push(int node) {
        myStack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }else{
            int temp = minStack.peek();
            minStack.push(node<temp?node:temp);
        }
    }

    public void pop() {
        if(myStack!=null){
            myStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return myStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}