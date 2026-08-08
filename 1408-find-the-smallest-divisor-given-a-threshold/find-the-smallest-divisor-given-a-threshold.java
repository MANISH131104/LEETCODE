class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int ele: nums){
            max = Math.max(max,ele);
        }
        int lo=1;
        int hi=max;
        int ans=max;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(divisor(mid,nums)<=threshold){
                ans=mid;
                hi=mid-1;
            } 
            else lo=mid+1;
        }
        return ans;
    }
    private static int divisor(int d, int[] arr){
        int sum = 0;
        for(int ele: arr){
            if(ele%d != 0) sum += (ele/d)+1;
            else sum += ele/d;
        }
        return sum;
    }
}