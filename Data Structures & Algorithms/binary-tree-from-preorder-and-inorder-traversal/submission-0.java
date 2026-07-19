
/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}*/
class Solution {

    TreeNode f(int[] pre, HashMap<Integer, Integer> map, int start, int end, int[] index){
        if (start>end) return null;
        TreeNode node = new TreeNode(pre[index[0]]);
        int ind = map.get(pre[index[0]]);
        index[0]++;
        node.left = f(pre, map, start, ind-1, index);
        node.right = f(pre, map, ind+1, end, index);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < inorder.length; j++) {
            map.put(inorder[j], j);
        }
        return f(preorder, map, 0, preorder.length-1, new int[]{0});
    }
}