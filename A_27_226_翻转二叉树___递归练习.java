package day_0330;

/**
 * 100 101 222
 * @author aml
 * @date 2021/4/24 11:02
 */
public class A_27_226_翻转二叉树___递归练习 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

//        过程
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

//        swap(root.left,root.right);
        return root;

    }

    private void swap(TreeNode left, TreeNode right) {
        TreeNode temp = left;
        left = right;
        right = temp;

    }
}
