import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
       int mindiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n - 2; i++) {   // fix 1st element
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - sum);

                if (diff < mindiff) {
                    mindiff = diff;
                    ans = sum;
                }
                // } else if (diff == mindiff) {
                //     ans = Math.max(ans, sum);
                // }

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
    }
    return ans;
    }
    }

