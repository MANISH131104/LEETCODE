class Solution {
    int idx = 0;
    public TreeNode solve(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        int rootVal = preorder[idx++];
        TreeNode root = new TreeNode(rootVal);

        int i = start;
        while (i <= end && inorder[i] != rootVal) {
            i++;
        }

        root.left = solve(preorder, inorder, start, i - 1);
        root.right = solve(preorder, inorder, i + 1, end);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0;
        return solve(preorder, inorder, 0, inorder.length - 1);
    }
}
