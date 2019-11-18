package leetcode.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

        For example, given a 3-ary tree:
                     1
                /    |    \
             3       2      4
           /  \
        5       6
        We should return its level order traversal:

        [
        [1],
        [3,2,4],
        [5,6]
        ]
         

        Note:

        The depth of the tree is at most 1000.
        The total number of nodes is at most 5000.
*/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class N_aryTreeLevelOrderTraversal_429 {
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; i++){
                Node fadeRoot = queue.poll();
                int num = fadeRoot.children.size();
                for(int j = 0; j < num; j++){
                    queue.offer(fadeRoot.children.get(j));
                }
                list.add(fadeRoot.val);
            }
            result.add(list);
        }
        return result;
    }
    public static void main(String[] args){
        List<Node> children1 = new LinkedList<>();
        List<Node> children2 = new LinkedList<>();
        List<Node> children3 = new LinkedList<>();
        Node root = new Node(1,children1);
        children1.add(new Node(3,children2));
        children1.add(new Node(2,children3));
        children1.add(new Node(4,children3));
        children2.add(new Node(5,children3));
        children2.add(new Node(6,children3));

        System.out.print(N_aryTreeLevelOrderTraversal_429.levelOrder(root).toString());

    }
}
