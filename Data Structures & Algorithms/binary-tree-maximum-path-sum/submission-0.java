/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}*/
public class Solution {
    int max = Integer.MIN_VALUE;
    int f(TreeNode root){
        if(root == null) return 0;
        int l = Math.max(f(root.left), 0);
        int r = Math.max(f(root.right), 0);
        max = Math.max(max, l+r+ root.val);
        return root.val+Math.max(l,r);

    }
    public int maxPathSum(TreeNode A) {
        f(A);
        return max;

    }
}
