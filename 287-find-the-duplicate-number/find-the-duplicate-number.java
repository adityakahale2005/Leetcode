class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Find intersection point
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        // Find entrance of cycle
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}