class Solution {
    public void Inorder(TreeNode root, ArrayList<Integer> ans){
        if(root==null) return;
        Inorder(root.left,ans);
        ans.add(root.val);
        Inorder(root.right,ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Inorder(root,ans);
        if(ans.size()<k) return -1;
        return ans.get(k-1);
    }
}