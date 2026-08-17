class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int rightsum = 0;
        for(int num : nums){
            rightsum += num;
        }
        int leftsum = 0;
        for(int i=0 ; i<n ; i++){
            
            // update rightsum
            rightsum -= nums[i];

            if(leftsum == rightsum){
                return i;
            }
            
            // update leftsum
            leftsum += nums[i];
        }
        return -1;
    }
}