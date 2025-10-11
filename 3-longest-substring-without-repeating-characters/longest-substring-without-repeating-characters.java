class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int maxlen = 0;
        for(int i=0 ; i<s.length() ; i++){
            Set<Character> se = new HashSet<>();
            for(int j=i ; j<s.length() ; j++){
                if(se.contains(s.charAt(j))) 
                {   
                    maxlen = Math.max(maxlen,j-i);
                    break;
                }
                se.add(s.charAt(j));
                }
                maxlen = Math.max(maxlen, se.size());
            }
            return maxlen;
        }
    }
