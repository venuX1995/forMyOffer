import java.util.Scanner;
import java.util.Stack;

public class Unfold {
    private static Stack<String> stack = new Stack<>();

    public static String decodeString(String s) {
        if (s == null || s.length() == 0)
            return null;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            if (cha == '(' || cha == '[' || cha == '{') {
                stack.push(res.toString());
                res = new StringBuffer();
            } else if (cha == ')' || cha == ']' || cha == '}') {
                StringBuffer decode = new StringBuffer(stack.pop());
                if (!stack.isEmpty()) {
                    int num = Integer.valueOf(stack.pop());
                    while (num-- > 0) {
                        decode.append(res.toString());
                    }
                }
                res = decode;
            } else {
                int j;
                if (Character.isDigit(s.charAt(i))) {
                    j = i;
                    while (Character.isDigit(s.charAt(++j))) ;
                    stack.push(s.substring(i, j));
                    i = j - 1;
                } else {
                    res.append(s.charAt(i));
                }
            }

        }
        return res.reverse().toString();
    }

}
