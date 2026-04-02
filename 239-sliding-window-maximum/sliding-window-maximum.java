class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dq = new LinkedList<>();
        int ans[] = new int[n-k+1];

        for(int i=0 ; i<n ; i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){ // this maintains a window of size k
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

        if(i>=k-1){ // valid window 3-1 = 2(0,1,2 is valid window)
            ans[i-k+1] = nums[dq.peekFirst()];
        }
    }
     return ans;
    }
}