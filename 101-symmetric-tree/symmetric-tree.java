class Solution {
    public boolean check(TreeNode l,TreeNode r){
        if(l==null && r==null) return true;
        if(l==null || r==null) return false;
        if((l.val==r.val) && check(l.left,r.right) && check(l.right,r.left)) return true;
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
      return check(root.left,root.right);
    }
}