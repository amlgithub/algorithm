package day_0330;

import java.util.ArrayList;
import java.util.List;

/**
 * 113 129
 * @author aml
 * @date 2021/4/24 18:56
 */
public class A_29_257_二叉树的所有路径 {

//    binaryTreePaths：函数定义，传入一个节点，获取此节点到 叶子节点的所有路径
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
//      1. 递归终止条件
        if (root == null){
            return res;
        }
        if (root.left == null && root.right == null){
            res.add(String.valueOf(root.val)); //压栈到叶子节点时，返回操作
        }

//        2. 递归过程
        List<String> leftS = binaryTreePaths(root.left); // root所有左子树的路径
        for (String s : leftS){
            res.add(root.val + "->" + s);
        }
        List<String> rightS = binaryTreePaths(root.right); // root所有左子树的路径
        for (String s : rightS){
            res.add(root.val + "->" + s);
        }

        return  res;
    }
}
