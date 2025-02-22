/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    boolean isNum(char ch) {
        return '0' <= ch && ch <= '9';
    }

    TreeNode dfs(String traversal, int curDepth) {
        TreeNode root = null;
        if (nextDepth == curDepth) {
            root = new TreeNode(nextVal);
            getNext(traversal);
        }

        if (nextDepth > curDepth) {
            root.left = dfs(traversal, curDepth + 1);
        }
        if (nextDepth > curDepth) {
            root.right = dfs(traversal, curDepth + 1);
        }
        return root;
    }

    private int nextDepth = 0;
    private int nextVal = 0;
    private int i = 0;

    void getNext(String traversal) {
        int n = traversal.length();
        if (i == n) {
            nextDepth = -1;
            return;
        }

        int depth = 0;
        while (i < n && traversal.charAt(i) == '-') {
            depth++;
            i++;
        }
        int val = 0;
        while (i < n && isNum(traversal.charAt(i))) {
            val = val * 10 + (traversal.charAt(i) - '0');
            i++;
        }
        nextDepth = depth;
        nextVal = val;
    }

    public TreeNode recoverFromPreorder(String traversal) {
        getNext(traversal);
        return dfs(traversal, 0);
    }
}
