class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0 , r = 0 , max = 0;
        int n = s.length();

        HashSet<Character> charset = new HashSet<>();

        while(r < n){
            if(!charset.contains(s.charAt(r))){
                charset.add(s.charAt(r));
                r++;
                max = Math.max(charset.size() , max);
            }
            else{
                charset.remove(s.charAt(l));
                l++;
            }
        }
        return max;
    }
}