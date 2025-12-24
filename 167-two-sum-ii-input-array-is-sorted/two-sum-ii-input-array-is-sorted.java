class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i=0 , j=n-1;
        while(i<j){
            int add = numbers[i] + numbers[j];
            if(add < target){
                i++;
            }
            else if(add > target){
                j--;
            } else {
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{-1,-1};
}
}