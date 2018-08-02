package AmasonLeetcode.OA2CODING;

/**
 * Created by yehuixiang on 7/27/18.
 */


public class subTreeOfAnotherTree {
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }

    public static boolean traverse(TreeNode s, TreeNode t){
        return s != null &&(equal(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }

    public static boolean equal(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;

        return s.val == t.val && equal(s.left,t.left) && equal(s.right,t.right);
    }

    public static void main(String[] args){
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.print(subTreeOfAnotherTree.isSubtree(s,t));
    }
}
