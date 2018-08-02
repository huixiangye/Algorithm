package AmasonLeetcode.TreeAndGraph;

/**
 * Created by yehuixiang on 7/18/18.
 */
public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumHelper(root,0);
    }

    public int sumHelper(TreeNode root, int sum){
        if(root == null)
            return 0;

        sum = sum + root.val;

        if(root.left == null && root.right == null)
            return sum;

        sum = sum *10;

        return sumHelper(root.left, sum) + sumHelper(root.right, sum);
    }

    public static void main(String[] args){
        TreeNode test1 = new TreeNode(4);
        test1.left = new TreeNode(9);
        test1.right = new TreeNode(0);
        test1.left.left = new TreeNode(5);
        test1.left.right = new TreeNode(1);

        SumRoottoLeafNumbers sumRoottoLeafNumbers = new SumRoottoLeafNumbers();
        System.out.print(sumRoottoLeafNumbers.sumNumbers(test1));
    }
}