package leetcode.BinarySearch.复杂二分法;

/**
 * Created by yehuixiang on 9/2/18.
 */

class TreeNode{

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }

}

public class ClosestBinarySearchTreeValue_270 {
    public static int closestValue(TreeNode root, double target) {
        return closet(root, target, root.val);
    }

    public static int closet(TreeNode root, double target, int val) {
        if(root == null) return val;
        if(Math.abs(root.val - target)<Math.abs(val-target)) val = root.val;

        if(root.val > target) val = closet(root.left, target,val);
        else if(root.val<target) val = closet(root.right,target,val);

        return val;
    }


}
