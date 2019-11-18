package leetcode.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its zigzag level order traversal as:
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            List<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode fadeRoot = queue.poll();
                if(flag){
                    temp.add(fadeRoot.val);
                }else{
                    ((LinkedList<Integer>) temp).addFirst(fadeRoot.val);
                }
                if(fadeRoot.left != null){
                    queue.offer(fadeRoot.left);
                }
                if(fadeRoot.right != null){
                    queue.offer(fadeRoot.right);
                }

            }
            flag = !flag;
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.print(BinaryTreeZigzagLevelOrderTraversal_103.zigzagLevelOrder(root).toString());

    }
}
