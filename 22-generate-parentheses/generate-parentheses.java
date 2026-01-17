class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(n,0,0,"",list);
        return list;
    }

    public static void generate(int n,int l , int r , String s , List<String> list ){
        if(r == n){
            list.add(s);
            return;
        }

        if(l < n) generate(n,l+1,r,s+"(",list);
        if(r < l) generate(n,l,r+1,s+")",list);
    }
}