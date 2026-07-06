/*
class Solution {

    static Boolean f(int i, int sum, int arr[]){
        if(sum==0) return true;
        if(i==0){
            return arr[i]==sum;
        }
        boolean nPick = f(i-1, sum, arr);
        boolean pick = false;
        if (arr[i]<=sum){
            pick = f(i-1, sum-arr[i], arr);
        }
        return pick||nPick;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        return f(arr.length-1, sum, arr);

    }
}*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;

    }
}