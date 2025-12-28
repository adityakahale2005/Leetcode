class MedianFinder {

    PriorityQueue<Integer> left_max_heap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right_min_heap = new PriorityQueue<>();

    public MedianFinder() {}

    public void addNum(int num) {

        // Step 1: Add element
        if (left_max_heap.isEmpty() || num < left_max_heap.peek()) {
            left_max_heap.add(num);
        } else {
            right_min_heap.add(num);
        }

        // Step 2: Balance heaps
        if (left_max_heap.size() - right_min_heap.size() > 1) {
            right_min_heap.add(left_max_heap.poll());
        } 
        else if (right_min_heap.size() - left_max_heap.size() > 1) {
            left_max_heap.add(right_min_heap.poll());
        }
    }

    public double findMedian() {

        if (left_max_heap.size() == right_min_heap.size()) {
            return (left_max_heap.peek() + right_min_heap.peek()) / 2.0;
        }

        return (left_max_heap.size() > right_min_heap.size())
                ? left_max_heap.peek()
                : right_min_heap.peek();
    }
}
