package AmasonLeetcode.TreeAndGraph;

import AmasonLeetcode.TreeAndGraph.TreeNode;
import AmasonLeetcode.TreeAndGraph.BinaryTreeLevelOrderTraversal;

/**
 * Created by yehuixiang on 7/18/18.
 */


public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null) return null;
        return builtMBT(nums, 0, nums.length-1);
    }

    public TreeNode builtMBT(int[] nums, int start, int end){
        if(start > end) return null;

        int indexMax = start;
        for(int i =start+1;i<=end;i++){
            if(nums[i]>nums[indexMax])
                indexMax = i;
        }

        TreeNode root = new TreeNode(nums[indexMax]);
        root.left = builtMBT(nums,start,indexMax-1);
        root.right = builtMBT(nums,indexMax+1,end);

        return root;
    }

    public static void main(String[] args){
        int[] test = {3,2,1,6,0,5};

        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        TreeNode res = maximumBinaryTree.constructMaximumBinaryTree(test);
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        System.out.print(binaryTreeLevelOrderTraversal.levelOrder(res));
    }
}
