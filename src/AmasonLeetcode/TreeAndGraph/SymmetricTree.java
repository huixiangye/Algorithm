package AmasonLeetcode.TreeAndGraph;

/**
 * Created by yehuixiang on 7/18/18.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode root1, TreeNode root2){
        if(root1 == null &&root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;

        return (root1.val == root2.val) && isMirror(root1.left, root2.right) &&
                isMirror(root1.right,root2.left);
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.print(symmetricTree.isSymmetric(root1));
    }
}
