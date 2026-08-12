class Solution {
    public boolean isHappy(int n) {
        
        HashSet<Integer> num = new HashSet<>();

        while(n != 1){

            if(num.contains(n)){
                return false;
            }
            num.add(n);

            int sum = 0;
            while(n>0){
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return true;
}
}