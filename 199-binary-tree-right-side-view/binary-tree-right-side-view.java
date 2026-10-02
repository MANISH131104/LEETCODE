class Solution {
    public void preOrder(TreeNode root,int level,List<Integer> ans){
        if(root==null) return;
        if(level==ans.size()){
            ans.add(root.val);
        }
        preOrder(root.right,level+1,ans);
        preOrder(root.left,level+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root,0,ans);
        return ans;
    }
}