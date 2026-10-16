class Solution {
    HashMap<TreeNode,TreeNode> parent = new HashMap<>();
    void inOrder(TreeNode root){
        if(root==null) return;
        if(root.left != null){
            parent.put(root.left,root);
            inOrder(root.left);
        }
        if(root.right != null){
            parent.put(root.right,root);
            inOrder(root.right);
        }
    }
    void BFS(TreeNode target,int k, List<Integer> ans){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);

        HashSet<TreeNode> set = new HashSet<>();
        set.add(target);
       
        while(q.size()>0 && k>0){
            int n = q.size();
            while(n>0){
                TreeNode curr = q.poll();
                n--;

                if(curr.left != null && !set.contains(curr.left)){
                    q.add(curr.left);
                    set.add(curr);
                } 
                if(curr.right != null && !set.contains(curr.right)){
                    q.add(curr.right);
                    set.add(curr);
                } 
                if(parent.containsKey(curr)){
                    TreeNode p = parent.get(curr);
                    if (!set.contains(p)){
                        q.add(p);
                        set.add(p);
                    }
                }
            }
            k--;
        }
        while(q.size()>0){
            ans.add(q.poll().val);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root);
        BFS(target,k,ans);
        return ans;
    }
}