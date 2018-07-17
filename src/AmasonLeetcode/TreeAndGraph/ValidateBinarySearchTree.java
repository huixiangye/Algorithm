package AmasonLeetcode.TreeAndGraph;


/**
 * Created by yehuixiang on 7/17/18.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        return helper(root, null ,null);
    }

    public boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null)
            return true;

        //the left subtree invalid
        if(max != null && root.val >= max)
            return false;

        //the right subtree invalid
        if(min != null && root.val <= min)
            return false;

        return helper(root.left,min,root.val) && helper(root.right, root.val,max);
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST(root1));
        System.out.println(validateBinarySearchTree.isValidBST(root2));
    }
}
