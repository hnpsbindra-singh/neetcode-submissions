

class MinStack {

    class pair{
        int ele;
        int min;

        public pair(int ele, int min) {
            this.ele = ele;
            this.min = min;
        }
    }
    Stack<pair> st;
    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new pair(val, val));
        } else {
            st.push(new pair(val, Math.min(val, st.peek().min)));
        }
    }

    public void pop() {
        if (st.isEmpty()) return;
        st.pop();
    }

    public int top() {
        if (st.isEmpty()) return -1;
        return st.peek().ele;
    }

    public int getMin() {
        if (st.isEmpty()) return -1;
        return st.peek().min;
    }
}
