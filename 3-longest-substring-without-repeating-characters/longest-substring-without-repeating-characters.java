class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int maxlen = 0;
        int l = 0;
        Set<Character> se = new HashSet<>();
        for(int r=0 ; r<s.length() ; r++){
                if(se.contains(s.charAt(r))){
                    while(l<r && se.contains(s.charAt(r))){
                    se.remove(s.charAt(l));
                    l++;
                }
                }
                se.add(s.charAt(r));
                maxlen = Math.max(maxlen,r-l+1);
            }
            return maxlen;
        }
    }

