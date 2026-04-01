class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k == n ) return "0";

        Stack<Character> st = new Stack<>();
        
        for(int i=0 ; i<n ; i++){
            char curr = num.charAt(i);
            while(!st.isEmpty() && k > 0 && st.peek() > curr){
                st.pop();
                k = k-1;
            }
            st.push(curr);
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k = k-1;
        }

        StringBuilder res = new StringBuilder("");
        while(!st.isEmpty()){
           res.append(st.pop());
        }
        res.reverse();

        while(res.length()>0 && res.charAt(0) == '0'){
            res.deleteCharAt(0);
        }

        if(res.length() == 0)return "0";
        else return res.toString();

        
    }
}