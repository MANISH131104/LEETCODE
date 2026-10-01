class Solution {
    class NodeInfo {
        TreeNode node;
        int row;
        int col;

        NodeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> list = new ArrayList<>();
        Queue<NodeInfo> q = new LinkedList<>();
        q.add(new NodeInfo(root, 0, 0));

        while (!q.isEmpty()) {
            NodeInfo curr = q.poll();
            list.add(curr);

            if (curr.node.left != null) {
                q.add(new NodeInfo(curr.node.left,curr.row + 1,curr.col - 1));
            }

            if (curr.node.right != null) {
                q.add(new NodeInfo(curr.node.right,curr.row + 1,curr.col + 1));
            }
        }

        Collections.sort(list, (a, b) -> {
            if (a.col != b.col)
                return a.col - b.col;

            if (a.row != b.row)
                return a.row - b.row;

            return a.node.val - b.node.val;
        });

        List<List<Integer>> ans = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        for (NodeInfo curr : list) {

            if (curr.col != prevCol) {
                ans.add(new ArrayList<>());
                prevCol = curr.col;
            }
            ans.get(ans.size() - 1).add(curr.node.val);
        }
        return ans;
    }
}