package day_0330;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author aml
 * @date 2021/4/8 15:31
 */
public class A_22_145_二叉树的后序遍历_非递归 {

    private class Command{
        String s;
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    }

    /**
     * 后序遍历
     * 计算机模拟的指令为
     * gol goR print
     * 压入栈中时为：
     * print
     * goR
     * goL
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
//        初始栈
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()){
            Command command = stack.pop();
            if (command.s.equals("print")){
                res.add(command.node.val);
            }else {
                assert command.s.equals("go");
                stack.push(new Command("print", command.node));
                if (command.node.right != null){
                    stack.push(new Command("go",command.node.right));
                }
                if (command.node.left != null){
                    stack.push(new Command("go", command.node.left));
                }
            }
        }

        return res;
    }

}
