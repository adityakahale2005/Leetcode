class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int subsets = (1 << nums.length);
        for(int i=0 ; i<subsets ; i++){
            List<Integer> ss = new ArrayList<>();
            for(int j=0 ; j<=nums.length-1 ; j++){
                if((i & (1<<j)) != 0){
                    ss.add(nums[j]);
                }
            }
            ans.add(ss);
        }
        return ans;
    }
}