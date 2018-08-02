package AmasonLeetcode.TreeAndGraph;

/**
 * Created by yehuixiang on 7/18/18.
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }

    public boolean traverse(TreeNode s, TreeNode t){
        return s != null &&(equal(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }

    public boolean equal(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;

        if(s == null || t == null)
            return true;


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

        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        System.out.print(subtreeOfAnotherTree.isSubtree(s,t));
    }
}
