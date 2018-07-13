package AmasonLeetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yehuixiang on 7/11/18.
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.

 Example:

 Input: [1,2,3,null,5,null,4]
 Output: [1, 3, 4]
 Explanation:

      1            <---
    /   \
   2     3         <---
    \     \
     5     4       <---

 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size;i++){
                TreeNode temp = queue.remove();

                if(i == size-1){
                    res.add(temp.val);
                }

                if(temp.left != null){
                    queue.add(temp.left);
                }

                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        System.out.println(binaryTreeRightSideView.rightSideView(treeNode));

    }
}
