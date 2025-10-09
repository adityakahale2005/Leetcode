
class Solution {
    public int longestConsecutive(int[] nums) {
        // Step 1: Handle the edge case of an empty or null array.
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 2: Create a HashSet for O(1) lookups and add all numbers.
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestSeq = 0;

        // Step 3: Iterate through the numbers in the set.
        for (int num : numSet) {
            // Step 4: Check if this number is the start of a sequence.
            // This is the key optimization.
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentSeq = 1;

                // Step 5: Count the length of the sequence starting from num.
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSeq++;
                }

                // Step 6: Update the maximum length found so far.
                longestSeq = Math.max(longestSeq, currentSeq);
            }
        }

        return longestSeq;
    }
}