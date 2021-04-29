package day_0330;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 341
 * @author aml
 * @date 2021/4/8 14:33
 */
public class A_20_144_二叉树的前序遍历_非递归 {
//结构体执行何种命令, 模拟计算机指令
    private class Command{
        String s; // go , print 命令
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    }

    /**
     * 二叉树前序遍历
     * 非递归，先后节点、再左节点、最后根节点
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        /**正常访问时先序：print goL goR
         * ->  转换成栈时为：
         * print
         * goL
         * goR
         */
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root)); //初始化过程，最开始访问root节点
        while (!stack.isEmpty()){
            Command command = stack.pop();
            if (command.s.equals("print")){
                res.add(command.node.val);
            }else {
                assert command.s.equals("go");
                if (command.node.right != null){
                    stack.push(new Command("go", command.node.right));
                }
                if (command.node.left != null){
                    stack.push(new Command("go", command.node.left));
                }

//                最后打印
                stack.push(new Command("print", command.node));
            }
        }
        return res;
    }

}
