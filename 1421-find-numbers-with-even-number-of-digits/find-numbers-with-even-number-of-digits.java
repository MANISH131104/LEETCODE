class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            int digit = 0;
            int num = nums[i];
            while(num>0){
                int fd = num%10;
                digit++;
                num = num/10;
            }
            if(digit%2==0) ans++;
        }
        return ans;
    }
}