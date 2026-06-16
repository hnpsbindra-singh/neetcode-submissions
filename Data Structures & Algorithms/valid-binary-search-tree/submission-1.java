/* class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }*/

 class Solution {
    boolean f(TreeNode root, int high, int low){
        if(root==null) return true;
        if(root.val>=high||root.val<=low) return false;
        return f(root.left, root.val, low) && f(root.right, high, root.val);
    }

     public boolean isValidBST(TreeNode root) {
        return f(root, Integer.MAX_VALUE, Integer.MIN_VALUE);

     }
 }
