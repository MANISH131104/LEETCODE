class Solution {
    long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        return (int)((findPower(5, even) * findPower(4, odd)) % MOD);
    }
    public long findPower(long a, long b){
        if(b==0) return 1;
        long call = findPower(a,b/2);
        if(b%2==0) return (call*call)%MOD;
        else return (a * call % MOD * call) % MOD;
    }
}