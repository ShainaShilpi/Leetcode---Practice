/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
  public String serialize(TreeNode root) {
    if (root == null)
      return "";

    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));

    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      if (node == null) {
        sb.append("n ");
      } else {
        sb.append(node.val).append(" ");
        q.offer(node.left);
        q.offer(node.right);
      }
    }

    return sb.toString();
  }

  public TreeNode deserialize(String data) {
    if (data.equals(""))
      return null;

    final String[] vals = data.split(" ");
    TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
    Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));

    for (int i = 1; i < vals.length; i += 2) {
      TreeNode node = q.poll();
      if (!vals[i].equals("n")) {
        node.left = new TreeNode(Integer.parseInt(vals[i]));
        q.offer(node.left);
      }
      if (!vals[i + 1].equals("n")) {
        node.right = new TreeNode(Integer.parseInt(vals[i + 1]));
        q.offer(node.right);
      }
    }

    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));