class Solution {
    int max = 0;
    int height(TreeNode root){
        if(root==null) return 0;
        int left=0;
        if(root.left!=null){
            left = 1 + height(root.left);   
        }
        int right=0;
        if(root.right!=null){
            right = 1 + height(root.right);
        }
        max = Math.max(max, left+right);
        return Math.max(left, right);
        
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;

    }
}
