class StockSpanner {
     List<Integer> prices;
    public StockSpanner() {
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
         prices.add(price);
        int i = prices.size() - 1;
        int span = 1;
        for(int j=i-1 ; j>=0 ; j--){
            if(prices.get(j) <= price){
                span++;
            } else {
                break;
            }
        }
         return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */