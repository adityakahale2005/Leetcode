class Solution {
    public int[] topKFrequent(int[] nums, int k) {
                // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // Step 2: Min Heap (based on frequency)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        // Step 3: Add elements to heap
        for(int key : map.keySet()){
            int freq = map.get(key);

            pq.add(new int[]{key, freq});

            if(pq.size() > k){
                pq.poll(); // remove lowest freq
            }
        }

        // Step 4: Store result
        int[] result = new int[k];
        int i = 0;

        while(!pq.isEmpty()){
            result[i] = pq.poll()[0];
            i++;
        }

        return result;
    }
}