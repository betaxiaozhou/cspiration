package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Edward on 28/07/2017.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * 103. Binary Tree Zigzag Level Order Traversal
     * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

     For example:
     Given binary tree [3,9,20,null,null,15,7],
          3
         / \
        9  20
      /  \
     15   7
     [
     [3],
     [20,9],
     [15,7]
     ]
     time : O(n)
     space : O(n);
     * @param root
     * @return
     */

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean x = true;//奇数层还是偶数层
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();//把他当成栈/数组使用,比我的方法更好，他少使用了一个栈
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (x) {
                    list.add(cur.val);
                } else {
                    list.add(0, cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(list);
            x = x ? false : true;//取反
        }
        return res;
    }
    
    
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList();
        Stack<TreeNode> stack = new Stack();
        queue.offer(root);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll(); 
                if(level%2!=0){
                    levelList.add(cur.val);
                }else {
                    stack.push(cur);
                } 
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            level++;
            while(!stack.isEmpty()){
                levelList.add(stack.pop().val);
            }
            res.add(levelList);
        }
        return res;
    }
}
