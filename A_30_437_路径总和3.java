package day_0330;

/**
 * @author aml
 * @date 2021/4/24 19:25
 */
public class A_30_437_路径总和3 {
//此函数（f）含义：
//    在以root为根节点的二叉树中，寻找和为sum的路径，返回这样的路径个数
    public int pathSum(TreeNode root, int targetSum) {

        if (root == null){
            return 0;
        }
//        递归过程分为两种情况，包含当前root节点； 不包含情况
        int res = findPath(root, targetSum); //这个是包含当前root节点

//        不包含情况
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right,targetSum);

        return res;

    }

//    在以node为根节点的二叉树中，寻找包含node节点的路径，和为sum
//    返回这样的路径个数
    private int findPath(TreeNode node, int sum) {
        if (node == null){
            return 0;
        }
        int res = 0;
        if (node.val == sum){
            res += 1;
        }

        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);

        return res;
    }
}
