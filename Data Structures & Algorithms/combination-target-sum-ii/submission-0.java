import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    void f(int[] arr, int target, List<List<Integer>> res, List<Integer> temp, int i){
        if(target == 0){
                res.add(new ArrayList<>(temp));
                return;
        }
        if(i>=arr.length){
            return;
        }
        
        if(arr[i]<=target){
            temp.add(arr[i]);
            f(arr, target-arr[i], res, temp, i+1);
            temp.remove(temp.size()-1);
        }
        int next = i+1;
        while (next< arr.length&&arr[next]==arr[next-1]){
            next++;
        }
        f(arr, target, res, temp, next);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        f(candidates, target, res, temp, 0);

        return res;
    }
}
