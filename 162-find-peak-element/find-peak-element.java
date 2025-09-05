class Solution { // peak = arr[i-1] < arr[i] > arr[i+1]
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n==1) return 0; // if arr has only one no its the peak
        if (nums[0] > nums[1]) return 0; // if first element is peak
        if (nums[n-2] < nums[n-1]) return n-1; // if last is peak

        int low=1;
        int high = n-2;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            } else if (nums[mid] < nums[mid-1]){
                high = mid - 1;
            } else if (nums[mid] > nums[mid-1]){
                low = mid + 1;
            }
        }
        return -1;
    }
}