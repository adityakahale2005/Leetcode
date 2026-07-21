class Solution {
    public String removeDigit(String number, char digit) {

        int n = number.length();

        int ri = -1; // remove index

        for(int i=0 ; i<n ; i++){
            if(number.charAt(i) == digit){
                ri = i;

            if(i+1<n && number.charAt(i+1)>digit){
                break;
            }
        }
    }
    return number.substring(0,ri) + number.substring(ri+1);
}
}