class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public void storeLeftNodes(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    public BSTIterator(TreeNode root) {
        storeLeftNodes(root);
    }
    
    public int next() {
        TreeNode ans = st.peek();
        st.pop();

        storeLeftNodes(ans.right);
        return ans.val;
    }
    
    public boolean hasNext() {
        return st.size()>0;
    }
}
