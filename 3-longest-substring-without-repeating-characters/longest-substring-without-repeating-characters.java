class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int maxlen = 0;
        int len = 0;
        for(int i=0 ; i<s.length() ; i++){
            Set<Character> se = new HashSet<>();
            for(int j=i ; j<s.length() ; j++){
                if(se.contains(s.charAt(j))) break;
                {   
                    len = j-i+1;
                    maxlen = Math.max(len,maxlen);
                }
                se.add(s.charAt(j));
                }
            }
            return maxlen;
        }
    }