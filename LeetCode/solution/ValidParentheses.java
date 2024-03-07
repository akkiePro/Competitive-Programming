import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * @author Akash Prajapati
 */
public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.isValid("{{}([])}"));
    }
}
/*
* case1: "()"
* case2: "()[]{}"
* case3: "{{}([])}"
* case4: "(()"
* case5: "())"
* case6: "(]"
* case7: "{{}([)]}"
* case8: ")"
* */

/**
 * self solution
 */
/*
class Solution {
    private final Map<Character, Character> format;
    private final Stack<Character> stack;
    public Solution() {
        format = new HashMap<>();
        format.put(')', '(');
        format.put('}', '{');
        format.put(']', '[');
        stack = new Stack<>();
    }
    public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek() == format.get(s.charAt(i))) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.empty())
            return true;
        else
            return false;
    }
}
*/

/**
 * optimised solution
 */
class Solution {
    public boolean isValid(String s) {
        final char[] chars = s.toCharArray();
        int len = chars.length;
        char[] stk = new char[len];
        int stkIndex = -1;

        for (int i = 0; i < len; i++) {
            char ch = chars[i];
            if (ch == '(' || ch == '{' || ch == '[') {
                stk[++stkIndex] = ch;
            } else {
                if (stkIndex < 0) {
                    return false;
                }
                char popped = stk[stkIndex--];
                if ((popped == '(' && ch != ')')
                        ||(popped == '{' && ch != '}')
                        ||(popped == '[' && ch != ']')
                ) {
                    return false;
                }
            }
        }
        return stkIndex == -1;
    }
}