class Solution {
    public int longestOnes(int[] nums, int k) {
            // Left pointer of the sliding window
        int left = 0;

        // Counter for zeros in the window
        int zerocount = 0;

        // Variable to store maximum window length
        int maxlen = 0;

        // Right pointer expands the window
        for (int right = 0; right < nums.length; right++) {

            // If current element is zero, increment zerocount
            if (nums[right] == 0) {
                zerocount++;
            }

            // If zerocount exceeds k, move left and adjust zerocount
            if (zerocount > k) {
                if (nums[left] == 0) {
                    zerocount--;
                }
                // Shrink window from left
                left++; 
            }

            // Update maximum window size
            maxlen = Math.max(maxlen, right - left + 1);
        }

        // Return the final result
        return maxlen;
    }
    }