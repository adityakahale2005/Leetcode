class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ss(0, nums, new ArrayList<>(), res);
        return res;
    }

    public static void ss(int idx, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(curr)); // important copy
            return;
        }

        // pick
        curr.add(nums[idx]);
        ss(idx + 1, nums, curr, res);

        // skip
        curr.remove(curr.size() - 1);
        ss(idx + 1, nums, curr, res);
    }
}