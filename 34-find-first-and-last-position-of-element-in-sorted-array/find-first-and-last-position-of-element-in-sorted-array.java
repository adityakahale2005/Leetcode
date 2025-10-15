class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = -1 ; int last = -1;
        int[] ans = new int[]{first,last};
        int low=0 ; int high=n-1;

        while(low<=high){ // lower_bound
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                first = mid;
                high = mid - 1;
            } 
            else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        low = 0 ; high = n-1;
         while(low<=high){ // higher bound
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                last = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target) {
               low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return new int[]{first,last};
    }
}