https://leetcode.com/problems/same-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//DFS
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
            
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
       return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

//Iterative
class Solution{
public boolean isSameTree(TreeNode p, TreeNode q) {
Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(p);
    queue.add(q);
    while(!queue.isEmpty()){
        TreeNode pRoot = queue.poll();
        TreeNode qRoot = queue.poll();
        if(pRoot == null && qRoot == null) continue;
        if(pRoot == null || qRoot == null || pRoot.val != qRoot.val) return false;
        TreeNode pChildL = pRoot.left;
        TreeNode qChildL = qRoot.left;
        TreeNode pChildR = pRoot.right;
        TreeNode qChildR = qRoot.right;
        queue.add(pChildL);
        queue.add(qChildL);
        queue.add(pChildR);
        queue.add(qChildR);
        
    }
    return true;
}
}

