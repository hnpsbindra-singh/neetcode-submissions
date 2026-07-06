class Solution {

   /* static Boolean f(int i, int sum, int arr[]){
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
    }*/



/*
    static Boolean memo(int i, int sum, int arr[], int[][] dp) {
          if (sum == 0) return true;
          if (i == 0) return arr[0] == sum;
          if (dp[i][sum] != -1) {
              return dp[i][sum] == 1;
          }
          boolean nPick = memo(i - 1, sum, arr, dp);
          boolean pick = false;
          if (arr[i] <= sum) {
              pick = memo(i - 1, sum - arr[i], arr, dp);
          }
          boolean result = pick || nPick;
          dp[i][sum] = result ? 1 : 0;
          return result;
      }
*/



     Boolean isSubsetSum(int arr[], int sum) {
        boolean[][] dp = new boolean[arr.length][sum+1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        if(arr[0]<=sum) {
            dp[0][arr[0]] = true;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <=sum ; j++) {
                boolean np = dp[i-1][j];
                boolean p = false;
                if(arr[i]<=j)
                {
                    p = dp[i-1][j-arr[i]];
                }
                dp[i][j] = np||p;

            }

        }
        return dp[arr.length-1][sum];

    }
    int sum(int[] arr){
         int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
            sum=sum+arr[i];
        }
        return sum;
    }

    public boolean canPartition(int[] nums) {
        int sum = sum(nums);
        if(sum%2!=0) return false;
        return isSubsetSum(nums, sum/2);

    }
}
