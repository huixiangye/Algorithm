package AmasonLeetcode.TreeAndGraph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yehuixiang on 7/18/18.
 */
public class TwoSumIV_InputIsaBST {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root,k,set);
    }

    public boolean find(TreeNode root, int k, Set<Integer> set){
        if(root == null)
            return false;

        if(set.contains(k-root.val))
            return true;

        set.add(root.val);

        return find(root.left,k,set) || find(root.right,k,set);
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(7);

        TwoSumIV_InputIsaBST twoSumIV_inputIsaBST = new TwoSumIV_InputIsaBST();
        System.out.print(twoSumIV_inputIsaBST.findTarget(root1,9));
    }
}
