
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int ele = st.peek();
                st.pop();

                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(maxArea,
                        heights[ele] * (nse - pse - 1));
            }
            st.push(i);
        }

        // remaining elements
        while (!st.isEmpty()) {
            int ele = st.peek();
            st.pop();

            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(maxArea,
                    heights[ele] * (nse - pse - 1));
        }

        return maxArea;
    }

    // 🔥 Main function
    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m]; // histogram array
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // build histogram
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            // apply histogram logic
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
}