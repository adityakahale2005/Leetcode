class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Count characters in s
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // A palindrome can have at most one odd-frequency character
        int odd = -1;

        for (int c = 0; c < 26; c++) {
            if (freq[c] % 2 == 1) {

                if (odd != -1) {
                    return "";
                }

                odd = c;
            }
        }

        int halfLen = n / 2;

        // Frequency of characters available in the left half
        int[] remaining = new int[26];

        for (int c = 0; c < 26; c++) {
            remaining[c] = freq[c] / 2;
        }

        char[] left = new char[halfLen];

        int i = 0;

        /*
         * Try to make the left half equal to
         * target's first half.
         */
        while (i < halfLen) {

            int targetChar = target.charAt(i) - 'a';

            // We can use the same character
            if (remaining[targetChar] > 0) {

                left[i] = (char) ('a' + targetChar);
                remaining[targetChar]--;

                i++;
            }

            else {

                /*
                 * We cannot match target[i].
                 *
                 * Try the smallest available character
                 * greater than target[i].
                 */
                int greater = findGreater(remaining, targetChar);

                if (greater != -1) {

                    left[i] = (char) ('a' + greater);
                    remaining[greater]--;

                    // Fill everything after i minimally
                    fillSmallest(left, i + 1, remaining);

                    return buildPalindrome(left, odd);
                }

                /*
                 * No greater character is possible here.
                 * We have to backtrack.
                 */
                break;
            }
        }

        /*
         * We successfully matched the entire left half.
         *
         * IMPORTANT:
         * Check the COMPLETE palindrome, not just the middle.
         *
         * This handles:
         *
         * s = "bb"
         * target = "ba"
         *
         * candidate = "bb"
         * bb > ba
         */
        if (i == halfLen) {

            String candidate = buildPalindrome(left, odd);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }

            /*
             * Candidate is <= target.
             *
             * Find the next lexicographically larger
             * permutation of the left half.
             */
            i = halfLen - 1;
        }

        else {

            /*
             * left[i] was never assigned.
             *
             * So start backtracking from i - 1.
             */
            i = i - 1;
        }

        /*
         * Find the next larger permutation of the left half.
         */
        while (i >= 0) {

            int current = left[i] - 'a';

            // Restore current character
            remaining[current]++;

            /*
             * Find smallest available character
             * greater than current.
             */
            int greater = findGreater(remaining, current);

            if (greater != -1) {

                left[i] = (char) ('a' + greater);
                remaining[greater]--;

                // Fill suffix with smallest characters
                fillSmallest(left, i + 1, remaining);

                return buildPalindrome(left, odd);
            }

            i--;
        }

        return "";
    }

    /*
     * Returns the smallest available character
     * strictly greater than x.
     */
    private int findGreater(int[] remaining, int x) {

        for (int c = x + 1; c < 26; c++) {

            if (remaining[c] > 0) {
                return c;
            }
        }

        return -1;
    }

    /*
     * Fill the remaining part of left half
     * using the smallest possible characters.
     */
    private void fillSmallest(
            char[] left,
            int start,
            int[] remaining) {

        int pos = start;

        for (int c = 0; c < 26; c++) {

            while (remaining[c] > 0) {

                left[pos] = (char) ('a' + c);
                remaining[c]--;
                pos++;
            }
        }
    }

    /*
     * Construct the complete palindrome.
     */
    private String buildPalindrome(char[] left, int odd) {

        StringBuilder sb = new StringBuilder();

        // Left half
        for (char c : left) {
            sb.append(c);
        }

        // Middle character for odd length
        if (odd != -1) {
            sb.append((char) ('a' + odd));
        }

        // Right half
        for (int i = left.length - 1; i >= 0; i--) {
            sb.append(left[i]);
        }

        return sb.toString();
    }
}