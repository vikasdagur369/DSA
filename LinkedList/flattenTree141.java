class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // Helper function to flatten the tree and return the tail of the flattened subtree
    public TreeNode flattenTree(TreeNode node) {
        // Base case: if the current node is null, return null
        if (node == null) {
            return null;
        }

        // If the current node is a leaf node (both left and right are null), return the node
        if (node.left == null && node.right == null) {
            return node;
        }

        // Recursively flatten the left subtree and get the tail of the flattened left subtree
        TreeNode leftTail = flattenTree(node.left);

        // Recursively flatten the right subtree and get the tail of the flattened right subtree
        TreeNode rightTail = flattenTree(node.right);

        // If there was a left subtree, we need to rewire the connections
        if (leftTail != null) {
            // Connect the tail of the left subtree to the start of the right subtree
            leftTail.right = node.right;
            // Move the flattened left subtree to the right
            node.right = node.left;
            // Set the left child of the current node to null
            node.left = null;
        }

        // Return the tail of the flattened subtree
        // If the right tail is not null, it is the new tail; otherwise, the left tail is the tail
        return rightTail == null ? leftTail : rightTail;
    }

    // Main function to flatten the binary tree starting from the root
    public void flatten(TreeNode root) {
        // Call the helper function to flatten the tree
        flattenTree(root);
    }
}
