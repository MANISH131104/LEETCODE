class Solution {
    public void inOrder(TreeNode root, ArrayList<Integer> ans){
        if(root==null) return;
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        for(int i=0; i<ans.size()-1; i++){
            if(ans.get(i)>=ans.get(i+1)) return false;
        }
        return true;
    }
}