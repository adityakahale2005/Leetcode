class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();

        for(int i=0 ; i<n-2 ; i++){

            int l = i+1;
            int r = n-1;
            
            while(l<r){
            int sum = nums[i] + nums[l] + nums[r];

            if(sum == 0){
                result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                l++;
                r--;
            }
            else if(sum<0){
                l++;
            }
            else{
                r--;
            }
        }
    }
     return new ArrayList<>(result);
}
}