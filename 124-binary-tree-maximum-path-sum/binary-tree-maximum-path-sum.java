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
    int maxSum = Integer.MIN_VALUE;
    public int solve(TreeNode root){
        if(root==null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);

        int neeche_hi_milgaya_ans = left+right+root.val;
        int koi_ek_aacha = Math.max(left,right)+root.val;
        int only_root_aacha = root.val;

       maxSum = Math.max(maxSum,
        Math.max(neeche_hi_milgaya_ans,
        Math.max(koi_ek_aacha, only_root_aacha)));
        
        return Math.max(koi_ek_aacha,only_root_aacha);
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
}