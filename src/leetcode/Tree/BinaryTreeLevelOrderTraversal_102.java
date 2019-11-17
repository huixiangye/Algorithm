package leetcode.Tree;

import java.util.LinkedList;
import java.util.List;

//define Tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeLevelOrderTraversal_102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> valList = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode fadeRoot = queue.poll();
                valList.add(fadeRoot.val);
                if(fadeRoot.left != null){
                    queue.offer(fadeRoot.left);
                }
                if(fadeRoot.right != null){
                    queue.offer(fadeRoot.right);
                }
            }
            result.add(valList);
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.print(BinaryTreeLevelOrderTraversal_102.levelOrder(root).toString());

    }
}
