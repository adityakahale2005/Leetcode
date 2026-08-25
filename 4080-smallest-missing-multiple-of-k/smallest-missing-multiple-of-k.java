import java.util.*;

class Solution {
    public int missingMultiple(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        // Store all numbers in the set
        for (int num : nums) {
            set.add(num);
        }

        // Check k, 2k, 3k, 4k...
        int x = k;

        while (set.contains(x)) {
            x = x + k;
        }

        return x;
    }
}