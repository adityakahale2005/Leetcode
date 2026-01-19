class Solution {
    public double myPow(double x, int n) {
        long N = n; // Convert to long to prevent overflow
        if (N < 0) {
        x = 1 / x;
        N = -N;
    }
          return power(x,N);
}

public double power(double x , long n){ // int a , b
   if(n==0) return 1;
   double call = power(x,n/2);
   if(n%2==0) return call*call;
   else return call*call*x;
}
}
