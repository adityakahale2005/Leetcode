class Solution {
    public int helper(int[] nums, int target,int l,int h) {
    if(l>h)return -1;
    int mid = l + (h-l)/2;
    if(nums[mid] == target) return mid;
    else if(nums[mid] > target) return helper(nums,target, 0,mid-1);
    else return helper(nums,target,mid+1,h);
    }

    public int search(int[] nums, int target) {
    int n = nums.length;
    return helper(nums,target,0,n-1);
}
}