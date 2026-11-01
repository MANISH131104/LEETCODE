class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int minEle=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i]<minEle) minEle=nums[i];
        }
        int opts=0;
        for(int i=0; i<n; i++){
            opts += (nums[i]-minEle);
        }
        return opts;
    }
}