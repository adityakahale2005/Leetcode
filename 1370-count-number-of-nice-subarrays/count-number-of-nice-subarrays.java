class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
         return nice(nums,k)-nice(nums,k-1);
    }
    int nice(int[] nums, int k) {
        int i=0,j=0,cnt=0,ans=0;
        while(j<nums.length) {
            cnt+=nums[j] & 1;
            while(cnt>k) {
                cnt-=nums[i] & 1;
                i++;
            }
            ans+=j-i+1;
            j++;
        }
        return ans;
    }
    }