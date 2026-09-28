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
class Solution {
    int diameter = 0;
    public int length(TreeNode root){
        if(root==null) return 0;
        int le = length(root.left);
        int re = length(root.right);
        diameter = Math.max(diameter,le+re);
        return Math.max(le,re)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        length(root);
        return diameter;
    }
}