
class Codec {


    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            TreeNode pop = queue.poll();
            if (pop == null){
                sb.append("null,");
                continue;
            }
            sb.append(pop.val).append(",");
            queue.add(pop.left);
            queue.add(pop.right);

        }
        return sb.toString();
    }


    public TreeNode deserialize(String data) {
        if (data.equals("null")){
            return null;
        }
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty()){
            TreeNode pop = q.poll();
            if (!arr[i].equals("null")){
                pop.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(pop.left);
            }
            i++;
            if (i< arr.length&&!arr[i].equals("null")){
                pop.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(pop.right);
            }
            i++;
        }


      return root;
    }
}

