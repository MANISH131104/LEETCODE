class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = 1000000;
        int[] best = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            best[i] = INF;
        }
        int ans = INF;
        int left = 0;
        int sum = 0;
        int minLen = INF;
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                int len = right - left + 1;
                if (best[left] != INF) {
                    ans = Math.min(ans, len + best[left]);
                }
                minLen = Math.min(minLen, len);
            }
            best[right + 1] = minLen;
        }
        return ans == INF ? -1 : ans;
    }
}