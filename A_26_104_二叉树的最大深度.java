package day_0330;

/**
 * 111
 * @author aml
 * @date 2021/4/24 10:30
 */
public class A_26_104_二叉树的最大深度 {

    /**
     * 定义函数含义为： maxDepth：在节点为root的二叉树中找到最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
//        1. 递归终止条件
        if (root == null){
            return 0;
        }

//        2. 递归过程，先获取以root为根节点的 left子树的高度，再获取right的高度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

//        +1的含义： 因为上面leftDepth 和 rightDepth 是以root为根节点的子树高度， 没有包含root节点
        return Math.max(leftDepth,rightDepth) + 1;

    }
}
