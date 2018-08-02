package AmasonLeetcode.TreeAndGraph;

/**
 * Created by yehuixiang on 7/18/18.
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        return closet(root,target,root.val);
    }

    public int closet(TreeNode root,double target, int res){
        if(root == null)
            return res;
        if(Math.abs(root.val - target)<Math.abs(res-target)) res = root.val;
        if(root.val > target) res = closet(root.left,target,res);
        else if(root.val < target) res = closet(root.right,target,res);

        return res;
    }

    public static void main(String[] args){
        TreeNode test = new TreeNode(4);
        test.left = new TreeNode(2);
        test.right = new TreeNode(5);
        test.left.left = new TreeNode(1);
        test.left.right = new TreeNode(3);

        ClosestBinarySearchTreeValue closestBinarySearchTreeValue = new ClosestBinarySearchTreeValue();
        System.out.print(closestBinarySearchTreeValue.closestValue(test,3.714286));
    }
}
