import java.util.*;

class StockSpanner {

    private Stack<Integer> st;
    private List<Integer> prices;

    public StockSpanner() {
        st = new Stack<>();
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        int i = prices.size();
        prices.add(price);
        while (!st.isEmpty() && prices.get(st.peek()) <= price) {
            st.pop();
        }

        int span;
        if (st.isEmpty()) {
            span = i + 1;
        } else {
            span = i - st.peek();
        }
        st.push(i);
        return span;
    }
}