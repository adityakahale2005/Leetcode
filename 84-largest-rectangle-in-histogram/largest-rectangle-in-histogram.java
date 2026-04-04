class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        int nse;
        int pse;
        int ele;

        for (int i = 0; i <= n; i++) {

           int currHeight = (i == n) ? 0 : heights[i];

           while(!st.isEmpty() && heights[st.peek()] > currHeight){
            ele = st.peek();
            st.pop();
            nse = i;
            pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(maxArea , heights[ele]*(nse - pse -1));
           }
           st.push(i);
        }

        // while(!st.isEmpty()){
        //     nse = n;
        //     ele = st.peek();
        //     st.pop();

        //     pse = st.isEmpty() ? -1 : st.peek();

        //     maxArea = Math.max(maxArea , heights[ele]*(nse - pse -1));
        // }
        return maxArea;
    }
}