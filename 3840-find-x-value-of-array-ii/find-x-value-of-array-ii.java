class Solution {
    int k;
    int[] nums;

    class Node {
        int product;
        int[] count;

        Node() {
            count = new int[k];
        }
    }

    Node[] tree;

    Node merge(Node left, Node right) {

        Node res = new Node();
        res.product = (left.product * right.product) % k;

        for (int r = 0; r < k; r++) {
            res.count[r] += left.count[r];
        }
        for (int r = 0; r < k; r++) {

            int newRemainder = (left.product * r) % k;

            res.count[newRemainder] += right.count[r];
        }

        return res;
    }
    void build(int node, int start, int end) {

        if (start == end) {

            tree[node] = new Node();

            int remainder = nums[start] % k;

            tree[node].product = remainder;
            tree[node].count[remainder] = 1;

            return;
        }

        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
    void update(int node, int start, int end, int index, int value) {

        if (start == end) {

            tree[node] = new Node();

            int remainder = value % k;

            tree[node].product = remainder;
            tree[node].count[remainder] = 1;

            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(2 * node, start, mid, index, value);
        } else {
            update(2 * node + 1, mid + 1, end, index, value);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
    Node query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return null;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;

        Node l = query(2 * node, start, mid, left, right);
        Node r = query(2 * node + 1, mid + 1, end, left, right);

        if (l == null) return r;
        if (r == null) return l;
        return merge(l, r);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.nums = nums;
        this.k = k;

        int n = nums.length;
        tree = new Node[4 * n];
        build(1, 0, n - 1);

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            nums[index] = value;

            update(1, 0, n - 1, index, value);
            Node result = query(1, 0, n - 1, start, n - 1);
            answer[q] = result.count[x];
        }

        return answer;
    }
}