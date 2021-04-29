package day_0330;

/**
 * 98 450 108 230 236
 * @author aml
 * @date 2021/4/24 19:57
 */
public class A_31_235_二叉搜索树的最近公共祖先_二叉搜索树 {

//    函数定义为： 在以root为根节点的二叉树中，找到p和q节点的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        assert(p != null && q != null);
        if (root == null){
            return null;
        }
//        从root.left 中寻找
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
//        从root.right 中寻找
        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }

        return root; //这个包含三种情况，p是祖先也是root，q是祖先也是root，root是祖先
    }
}
