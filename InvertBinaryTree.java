class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {   // BASE CASE
            return null;
        }
        // Swap Childs
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // Induction Hypothesis
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        return root;
    }
}