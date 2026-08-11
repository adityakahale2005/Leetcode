class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLenWindow = Integer.MAX_VALUE;
        int currsum = 0;
        int n = nums.length;

        int low = 0;
        int high = 0;

        while(high < n){

            currsum += nums[high];
            high++;

            while(currsum >= target){

                 int currWindowLength = high - low;

                 minLenWindow =  Math.min(minLenWindow,currWindowLength);

                 currsum -= nums[low];
                 low++;
            }
        }
        return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
    }
}