package AmasonLeetcode.OA2CODING;

import java.util.Stack;

/**
 * Created by yehuixiang on 7/27/18.
 * Example 1:

 Input: "()"
 Output: true
 Example 2:

 Input: "()[]{}"
 Output: true
 Example 3:

 Input: "(]"
 Output: false
 Example 4:

 Input: "([)]"
 Output: false
 Example 5:

 Input: "{[]}"
 Output: true
 */


public class ValidParentheses {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == ')'){
                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return false;
            }else if(c == ']'){
                if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else return false;
            }else if(c == '}'){
                if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
                else return false;
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args){
        //true
        System.out.println(ValidParentheses.isValid("()"));
        //true
        System.out.println(ValidParentheses.isValid("()[]{}"));
        //false
        System.out.println(ValidParentheses.isValid("(]"));
        //false
        System.out.println(ValidParentheses.isValid("([)]"));
        //true
        System.out.println(ValidParentheses.isValid("{[]}"));

    }
}
