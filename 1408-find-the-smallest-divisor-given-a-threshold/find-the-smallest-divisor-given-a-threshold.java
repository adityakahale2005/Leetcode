class Solution {
    public static int sumOfD(int[] nums , int d){
        int n = nums.length;
        int sum = 0;
        for(int i=0 ; i<n ; i++){
            sum += Math.ceil((double)(nums[i])/ (double)(d));
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
       int maxi = Integer.MIN_VALUE;
       int n = nums.length;
       if (n > threshold) return -1;
       for(int i=0 ; i<n ; i++){
        maxi = Math.max(nums[i] , maxi);
       }

       int low = 1 ; int high = maxi; 

       while(low<=high){
        int mid = (low+high)/2;
        if(sumOfD(nums,mid) <= threshold){
            high = mid - 1;
        }
        else {
            low = mid + 1;
        }
       }
       return low;
    }
}