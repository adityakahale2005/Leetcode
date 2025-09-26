class Solution {
    public int singleNumber(int[] nums) {

        int xor = 0; // every time loop iterates unique is updated

        for(int i = 0 ; i<nums.length ; i++){
            xor = xor ^ nums[i]; // a^a = 0 ^ is xor and a^0 = a
        }
        return xor;
        
    }
}