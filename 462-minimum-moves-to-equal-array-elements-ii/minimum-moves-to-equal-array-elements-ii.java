class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = nums[n/2];
        int opts=0;
        for(int i=0; i<n; i++){
            opts += Math.abs(mid-nums[i]);
        }
        return opts;
    }
}