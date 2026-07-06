/*


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
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
  }
*/


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int c = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < c; i++) {
                TreeNode x = q.poll();
                temp.add(x.val);
                if(x.left!=null){
                    q.add(x.left);
                }
                if (x.right!=null){
                    q.add(x.right);
                }
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
