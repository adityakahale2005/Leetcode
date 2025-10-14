class Solution {
    public int longestOnes(int[] nums, int k) {
      int len=0 , maxlen=0;
      int l=0 ,r=0 , n=nums.length;
      int zeroes = 0;
      while(r<n){
        if(nums[r] == 0){
            zeroes++;
        }
        if(zeroes > k){
          if(nums[l] == 0)zeroes--;
            l++;
        }  
        if(zeroes <= k){
        len = r-l+1;
        maxlen = Math.max(maxlen,len);
      }
      r++;
    }
    return maxlen;
}
}