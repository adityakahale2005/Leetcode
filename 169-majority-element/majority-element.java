class Solution {
    public int majorityElement(int[] nums) {
          int candidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];  // pick a new candidate
            }

            if (nums[i] == candidate) {
                count++;              // same number → increase count
            } else {
                count--;              // different number → decrease count
            }
        }

        return candidate;
    }
    }