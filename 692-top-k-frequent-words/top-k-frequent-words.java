import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        // Step 1: Frequency map
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Min Heap (size k)
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                int f1 = map.get(w1);
                int f2 = map.get(w2);

                if(f1 == f2) return w2.compareTo(w1); // reverse lex
                return f1 - f2; // smaller freq first
            }
        });

        // Step 3: Maintain only top k
        for(String key : map.keySet()){
            pq.add(key);
            if(pq.size() > k){
                pq.poll(); // remove worst
            }
        }

        // Step 4: Extract result
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }

        // Step 5: Reverse to get correct order
        Collections.reverse(result);

        return result;
    }
}