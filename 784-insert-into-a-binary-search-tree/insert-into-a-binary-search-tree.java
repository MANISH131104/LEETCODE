class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        attach(root,val);
        return root;
    }
    public void attach(TreeNode root, int key){
        if(root.val==key) return;
        else if(root.val<key){
            if(root.right == null)  root.right = new TreeNode(key);
            else attach(root.right,key);
        }
        else{
            if(root.left == null) root.left = new TreeNode(key);
            else attach(root.left,key);
        }
    }
}