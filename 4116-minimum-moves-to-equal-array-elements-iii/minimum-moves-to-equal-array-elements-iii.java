class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0; i<n; i++){
            max=Math.max(nums[i],max);
            sum += nums[i];
        }
        return (n*max)-sum;
    }
}