class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int rich = 0;
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                rich += accounts[i][j];
            }
            ans = Math.max(ans,rich);
            rich=0;
        }
        return ans;
    }
}