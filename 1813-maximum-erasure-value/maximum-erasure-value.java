class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int l = 0 , r = 0 , currsum = 0 , maxsum = 0;
        HashSet<Integer> set = new HashSet<>();

        while(r<n){
            if(!set.contains(nums[r])){
                set.add(nums[r]);
                currsum += nums[r];
                r++;

                maxsum = Math.max(currsum,maxsum);
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