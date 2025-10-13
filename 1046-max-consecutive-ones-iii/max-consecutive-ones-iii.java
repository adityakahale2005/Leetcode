class Solution {
    public int longestOnes(int[] nums, int k) {
           // Variable to store maximum length
        int maxLen = 0;

        // Loop to pick each possible start index
        for (int i = 0; i < nums.length; i++) {

            // Counter for zeros in current subarray
            int zeros = 0;

            // Loop to pick each end index for the subarray
            for (int j = i; j < nums.length; j++) {

                // If element is zero, increment zero counter
                if (nums[j] == 0) {
                    zeros++;
                }

                // If number of zeros exceeds allowed flips, break
                if (zeros > k) {
                    break;
                }

                // Update maximum length if current subarray is valid
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        // Return the maximum valid subarray length
        return maxLen;
    }
    }
