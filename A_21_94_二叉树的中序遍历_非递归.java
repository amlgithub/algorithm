package day_0330;

import test.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author aml
 * @date 2021/4/8 15:16
 */
public class A_21_94_二叉树的中序遍历_非递归 {
//    先使用command结构体，模拟计算机指令
    private class Command{
        String s; //指令，go, print
        TreeNode node; // 节点
       private Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    }

    /**
     * 中序遍历，非递归
     * 指令应该是：
     *  goL print goR
     *  转换为栈时(压入栈时) ：->
     *  goR
     *  print
     *  goL
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root)); //初始化访问根节点root
//      遍历
        while (!stack.isEmpty()){
            Command command = stack.pop();
            if (command.s.equals("print")){ //如果当前计算机执行的指令为 print,则将当前节点值放入返回值res中
                res.add(command.node.val);
            }else {
                assert command.s.equals("go");
                if (command.node.right != null){
                    stack.push(new Command("go", command.node.right));
                }
                stack.push(new Command("print", command.node));
                if (command.node.left != null){
                    stack.push(new Command("go", command.node.left));
                }
            }
        }
        return res;
    }
}
