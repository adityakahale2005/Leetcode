class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int l = 0 , r = 0 ;
        long currsum = 0 , maxsum = 0;
        HashSet<Integer> set = new HashSet<>();

        while(r<n){
            if(!set.contains(nums[r]) && set.size() < k){
                set.add(nums[r]);
                currsum += nums[r];
                r++;

                if(set.size() == k){

                maxsum = Math.max(maxsum,currsum);
                }
            }
            else{
                set.remove(nums[l]);
                currsum -= nums[l];
                l++;
            }
        }
        return maxsum;
    }
}