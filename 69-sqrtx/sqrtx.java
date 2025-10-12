
 class Solution {
    public int mySqrt(int x) {
      int low = 1;
        int high = x;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sq = (long) mid * mid;   // ✅ prevent overflow

            if (sq == x) {
                return mid;               // perfect square
            } else if (sq < x) {
                ans = mid;                // store current best
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans; // floor of sqrt(x)
    }
}
