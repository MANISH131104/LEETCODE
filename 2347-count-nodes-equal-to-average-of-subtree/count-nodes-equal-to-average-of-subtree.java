class Solution {
    public int size(TreeNode root){
        if(root==null) return 0;
        return 1+size(root.left)+size(root.right);
    }
    public int sum(TreeNode root){
        if(root==null) return 0;
        return root.val+sum(root.left)+sum(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        if(root==null) return 0;
        int count = 0;
        int size = size(root);
        int sum = sum(root);
        int average = sum/size;
        if(average==root.val){
            count++;
        }
        count += averageOfSubtree(root.left);
        count += averageOfSubtree(root.right);

        return count;
    }
}