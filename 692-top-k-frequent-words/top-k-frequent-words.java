class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String , Integer> map = new HashMap<>();
        
         // Step 1: Frequency map
        for(String word : words){
            map.put(word , map.getOrDefault(word,0)+1);
        }
        
         // Step 2: Max Heap Since we want sorted output
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a,b) -> {
            if(map.get(a).equals(map.get(b))){
                    return a.compareTo(b); // lexicographically smaller first
                }
            return map.get(b) - map.get(a);
            }
        );

       // Step 3: Add all words
       for(String key : map.keySet()){
            pq.add(key);
        }
        
        // Step 4: Extract top k
        List<String> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            result.add(pq.poll());
        }

        return result;
    }
}