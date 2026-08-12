class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        double maxAvg = Double.NEGATIVE_INFINITY;
        double currsum = 0;
        
        while(r < n){
            currsum += nums[r];
            r++;

            int windowSize = r - l;

            if(windowSize == k){

            double curravg = currsum / k;

            if(curravg > maxAvg){
                maxAvg = curravg;
            }

            currsum -= nums[l];
            l++;
        }
    }
    return maxAvg;
}
}