package day_0330;

import javafx.util.Pair;

import java.util.*;

/**
 *  107 103 199
 * @author aml
 * @date 2021/4/9 16:48
 */
public class A_23_102_二叉树的层序遍历 {

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null ){
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            // 核心地方，每次限制 队列中仅仅存放一整行 元素
            int n = queue.size(); // 每次将整行 数据 放进去
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<n; i++){  //将整行数据取出 放入 level中
                TreeNode node = queue.poll();
                level.add(node.val); // 将节点值放入level中
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }

            res.add(level);
        }

        return res;
    }




    /**
     * 二叉树层序遍历， 使用pair类似map的键值对
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }

//        可以使用队列，也可以使用LinkedList 有序数组
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
//        首先进行初始化
        queue.add(new Pair<>(root,0));
//        再进行遍历
        if (!queue.isEmpty()){
//            先取出对首元素
            Pair<TreeNode, Integer> first = queue.removeFirst();
            TreeNode node = first.getKey();
            Integer level = first.getValue();

//            这块是核心，经典，判断level == res.size,如果相等则说明 数组中还没有这层的 元素
            if (level == res.size()){
                res.add(new ArrayList<>());
            }
            assert level < res.size();
//            往本层（数组）放元素
            res.get(level).add(node.val);

            if (node.left != null){
//                往对尾 添加元素
                queue.addLast(new Pair<>(node.left, level+1));
            }
            if (node.right != null){
//                往对尾 添加元素
                queue.addLast(new Pair<>(node.right, level+1));
            }

        }

        return res;
    }
}
