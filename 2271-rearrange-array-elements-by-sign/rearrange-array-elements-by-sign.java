class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans1 = new int[n/2];
        int[] ans2 = new int[n/2];

        int p=0;
        int q=0;
        for(int i=0; i<n; i++){
            if(nums[i]>0) ans1[p++]=nums[i];
            else ans2[q++]=nums[i];
        }
        for(int i=0; i<n/2; i++){
            nums[2*i] = ans1[i];
            nums[(2*i)+1] = ans2[i];
        }
        return nums;
    }
}