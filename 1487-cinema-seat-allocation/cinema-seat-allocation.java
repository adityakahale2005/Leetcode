import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, HashSet<Integer>> rows = new HashMap<>();

        // Store reserved seats row-wise
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                rows.putIfAbsent(row, new HashSet<>());
                rows.get(row).add(col);
            }
        }

        // Rows with no relevant reservations can fit 2 families
        int ans = (n - rows.size()) * 2;

        for (HashSet<Integer> seats : rows.values()) {

            boolean left = true;    // seats 2-5
            boolean middle = true;  // seats 4-7
            boolean right = true;   // seats 6-9

            // Check 2-5
            for (int i = 2; i <= 5; i++) {
                if (seats.contains(i)) {
                    left = false;
                    break;
                }
            }

            // Check 4-7
            for (int i = 4; i <= 7; i++) {
                if (seats.contains(i)) {
                    middle = false;
                    break;
                }
            }

            // Check 6-9
            for (int i = 6; i <= 9; i++) {
                if (seats.contains(i)) {
                    right = false;
                    break;
                }
            }

            if (left && right) {
                ans += 2;
            } 
            else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}