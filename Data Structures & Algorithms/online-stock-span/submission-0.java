
class StockSpanner {
    class pair{
        int price;
        int span;

        public pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }
    Stack<pair> st;
    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!st.isEmpty()&&st.peek().price<=price){
            pair p = st.pop();
            span = span + p.span;
        }
        st.push(new pair(price, span));
        return span;
    }
}

