class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long check = 1000;
        while(check<=n){
            ans += (n-check)+1;
            check *= 1000;
        }
        return ans;
    }
}