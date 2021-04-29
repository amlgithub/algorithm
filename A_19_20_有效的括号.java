package day_0330;

import java.util.Stack;

/**
 * 150 71 144 94 145
 * @author aml
 * @date 2021/4/8 9:29
 */
public class A_19_20_有效的括号 {
    /**
     * o(n) o(n)
     * 栈 的使用
     * 栈顶元素反映了在嵌套的层次关系中， 最近的需要匹配的元素
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) =='('|| s.charAt(i)=='[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else {
                if (stack.size() == 0){
                    return false;
                }
//                将栈顶元素pop出来
                char c = stack.pop();
//                当前元素和栈顶元素进行匹配
                char match;
                if (s.charAt(i) == '}'){
                    match = '{';
                }else if (s.charAt(i) == ')'){
                    match = '(';
                }else {
                    assert(s.charAt(i) == ']');
                    match = '[';
                }

                if (c != match){
                    return false;
                }

            }
        }

        if (stack.size() != 0){
            return false;
        }

        return true;
    }


    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        printBool((new A_19_20_有效的括号()).isValid("()"));
        printBool((new A_19_20_有效的括号()).isValid("()[]{}"));
        printBool((new A_19_20_有效的括号()).isValid("(]"));
        printBool((new A_19_20_有效的括号()).isValid("([)]"));
    }
}
