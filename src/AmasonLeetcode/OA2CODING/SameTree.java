package AmasonLeetcode.OA2CODING;

/**
 * Created by yehuixiang on 7/27/18.
 * Given two binary trees, write a function to check if they are the same or not.

 Two binary trees are considered the same if they are structurally identical and
 the nodes have the same value.
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int i){
        this.val = i;
    }
}

public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null || q == null)
            return false;
        else if(p.val != q.val) return false;
        else return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root2.left = new TreeNode(2);
        root1.right = new TreeNode(1);
        root2.right = new TreeNode(1);
        System.out.print(SameTree.isSameTree(root1,root2));
    }
}
