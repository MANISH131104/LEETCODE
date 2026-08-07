class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int ele: weights){
            max = Math.max(max,ele);
            sum += ele;
        }
        int lo = max;
        int hi = sum;
        int ans = sum;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(days(mid,weights)<=days){
                hi = mid-1;
                ans = mid;
            }
            else lo = mid+1;
        }
        return ans;
    }
    private static int days(int capacity, int[] arr){
        int days = 0;
        int c = capacity;
        for(int ele: arr){
            if(c >= ele) c -= ele;
            else{
                days++;
                c = capacity-ele;
            }
        }
        days++;
        return days;
    }
}