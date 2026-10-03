class Solution {
    class pair{
        TreeNode node;
        int idx;
        pair(TreeNode node,int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int levelOrder(TreeNode root, int idx){
       LinkedList<pair> q = new LinkedList<>();
        q.add(new pair(root,idx));
        int width = Integer.MIN_VALUE;
        while(q.size()>0){
            int size = q.size();
            int leftMost = q.peek().idx;
            int rightMost = q.getLast().idx;
            width = Math.max(width,(rightMost-leftMost+1));
            while(size != 0){
                pair front = q.remove();
                TreeNode node = front.node;
                int index = front.idx;
                if(node.left != null) q.add(new pair(node.left, 2*index+1));
                if(node.right != null) q.add(new pair(node.right,2*index+2));

                size--;
            }
        }
        return width;
    }
    public int widthOfBinaryTree(TreeNode root) {
       int ans = levelOrder(root,0);
       return ans;
    }
}