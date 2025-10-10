class Solution {
    public static void Reverse(int[] nums, int start, int end) {
        while (start < end) {  // should be '<' not '<='
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // handle k > n

        // Step 1: Reverse the first n - k elements
        Reverse(nums, 0, n - k - 1);

        // Step 2: Reverse the last k elements
        Reverse(nums, n - k, n - 1);

        // Step 3: Reverse the entire array
        Reverse(nums, 0, n - 1);
}
}