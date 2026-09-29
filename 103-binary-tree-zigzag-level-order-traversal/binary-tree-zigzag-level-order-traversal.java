class Solution {
    public void zigZag(TreeNode root,List<List<Integer>> ans){
        if(root==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while(q.size()>0){
            int size = q.size();
            List<Integer> res = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode front = q.remove();
                if(leftToRight) res.add(front.val);
                else res.add(0,front.val);
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            ans.add(res);
            leftToRight = !leftToRight;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        zigZag(root,ans);
        return ans;
    }
}