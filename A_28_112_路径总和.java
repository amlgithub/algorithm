package day_0330;

/**
 * 111 404
 * @author aml
 * @date 2021/4/24 13:37
 */
public class A_28_112_路径总和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
//        考虑节点是否是 叶子节点
     /*   if (root.left == null && root.right == null && targetSum -root.val == 0){
            return true;
        }*/
//     同义替换
        if (root.left == null && root.right == null){
            return targetSum-root.val == 0;
        }


//        递归过程
        if (hasPathSum(root.left, targetSum - root.val)){
            return true;
        }

        if (hasPathSum(root.right, targetSum - root.val)){
            return true;
        }

        return false;

    }

}
