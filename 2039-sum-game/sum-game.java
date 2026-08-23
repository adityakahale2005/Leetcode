class Solution {
    public boolean sumGame(String num) {

        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;

        int leftQ = 0;
        int rightQ = 0;

        // First half
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        // Second half
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }

        int qDiff = leftQ - rightQ;
        int sumDiff = leftSum - rightSum;

        // Equal number of '?' on both sides
        if (qDiff == 0) {
            return sumDiff != 0;
        }

        // Bob can force equality only in this exact situation
        if (2 * sumDiff + 9 * qDiff == 0) {
            return false;
        }

        return true;
    }
}