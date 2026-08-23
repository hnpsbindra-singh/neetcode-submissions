class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int temp = n;
        while (temp!=0){
            int rem = temp%10;
            sum = sum + rem;
            prod = prod*rem;
            temp = temp/10;
        }
        int div = sum + prod;
        return n%div == 0;
    }
}