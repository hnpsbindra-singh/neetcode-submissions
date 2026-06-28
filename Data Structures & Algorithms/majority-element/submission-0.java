class Solution {
    public int majorityElement(int[] arr) {
        int ele = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(count==0){
                count++;
                ele = arr[i];
            } else if (arr[i]==ele) {
                count++;
            }else {
                count--;
            }

        }
        int verify=0;
        for (int i = 0; i < arr.length; i++) {
           if(arr[i]==ele){
               verify++;
           }
        }
        if(verify> arr.length/2){
            return ele;
        }
        return -1;
    }
}