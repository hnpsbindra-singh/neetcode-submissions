

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <asteroids.length; i++) {
            if (asteroids[i]>0){
                st.add(asteroids[i]);
            }else {
                while (!st.isEmpty()&&st.peek()>0&&Math.abs(asteroids[i])> st.peek()){
                    st.pop();
                }
                if (!st.isEmpty()&&Math.abs(asteroids[i])==st.peek()){
                    st.pop();
                }
                else if (st.isEmpty()||st.peek()<0){
                    st.add(asteroids[i]);
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>(st);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size() ; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}