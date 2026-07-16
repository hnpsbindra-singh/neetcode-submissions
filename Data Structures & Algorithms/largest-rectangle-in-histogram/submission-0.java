

class Solution {
    public static int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] next = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return next;
    }

    public static int[] previousSmaller(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return prev;
    }
    public int largestRectangleArea(int[] heights) {
        int[] next = nextSmaller(heights);
        int[] prev = previousSmaller(heights);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int width = next[i]-prev[i]-1;
            int height = heights[i];
            max = Math.max(max, height*width);
        }
        return max;
    }
    
}