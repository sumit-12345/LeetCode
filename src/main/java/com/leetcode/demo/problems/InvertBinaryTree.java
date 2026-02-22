package com.leetcode.demo.problems;

public class InvertBinaryTree {
    class TreeNode {
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
    }
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
    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
            InvertBinaryTree solution = new InvertBinaryTree();
            TreeNode root = solution.new TreeNode(4);
            root.left = solution.new TreeNode(2);
            root.right = solution.new TreeNode(7);
            root.left.left = solution.new TreeNode(1);
            root.left.right = solution.new TreeNode(3);
            root.right.left = solution.new TreeNode(6);
            root.right.right = solution.new TreeNode(9);

            //Before inversion
            System.out.println("Original Tree (Level Order):");
            solution.inorder(root);
            TreeNode invertedRoot = solution.invertTree(root);
            // After inversion
            System.out.println("\nInverted Tree (Level Order):");
            solution.inorder(invertedRoot);
            // The inverted tree will have the structure:
            //     4
            //    / \
            //   7   2
            //  / \ / \
            // 9  6 3  1
    }
}


