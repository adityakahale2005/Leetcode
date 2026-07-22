class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long last = nums[n-1];

        for(int i=n-2 ; i>=0 ; i--){
            if(nums[i] > last){
                last = nums[i];
            }else{
                last += nums[i];
            }
            }
            return last;
        }
}