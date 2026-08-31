class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] answer = {-1, -1};

        // We need at least 3 nodes to have a critical point
        if (head == null || head.next == null || head.next.next == null) {
            return answer;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        int position = 1;

        int first = -1;
        int previous = -1;

        int minDistance = Integer.MAX_VALUE;

        while (curr.next != null) {

            int nextValue = curr.next.val;

            // Check if curr is a critical point
            boolean isCritical =
                    (curr.val > prev.val && curr.val > nextValue) ||
                    (curr.val < prev.val && curr.val < nextValue);

            if (isCritical) {

                // This is the first critical point
                if (first == -1) {
                    first = position;
                }

                // We already found one critical point
                if (previous != -1) {
                    minDistance = Math.min(
                        minDistance,
                        position - previous
                    );
                }

                previous = position;
            }

            prev = curr;
            curr = curr.next;
            position++;
        }

        // Fewer than 2 critical points
        if (first == -1 || previous == first) {
            return answer;
        }

        int maxDistance = previous - first;

        return new int[]{minDistance, maxDistance};
    }
}