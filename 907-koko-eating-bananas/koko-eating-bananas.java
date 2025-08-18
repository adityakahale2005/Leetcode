class Solution {
    public static int findmax(int[] piles){
        int n = piles.length;
        int maxi = Integer.MIN_VALUE;
        for(int i=0 ; i<n ; i++){
            maxi =  Math.max(maxi,piles[i]);
        }
        return maxi;
    }

    public static int calculateHourly(int[] piles , int hourly){
        int n = piles.length;
        int total_hours = 0;
        for(int i=0 ; i<n ; i++){
            total_hours += Math.ceil((double)(piles[i])/(double)(hourly));
        }
        return total_hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high = findmax(piles);
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low+high)/2;
            int totalH = calculateHourly(piles,mid);

            if(totalH <= h){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}