

/*class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }*/
  public class Solution {
      public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = false;
        q.add(root);
        while (!q.isEmpty()){
            int c = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < c; i++) {
                TreeNode top = q.poll();
                temp.add(top.val);
                if(top.left!=null) q.add(top.left);
                if(top.right!=null) q.add(top.right);
            }
            if(flag==false){
                res.add(new ArrayList<>(temp));
            }
            else {
                Collections.reverse(temp);
                res.add(temp);
            }
            flag = !flag;
        }
        return res;
    }
}
