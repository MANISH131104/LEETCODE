class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int opts=0;
        for(int i=0; i<n; i++){
            while(nums[i]!=nums[n-1]){
                nums[i]++;
                opts++;
            }
        }
        return opts;
    }
}