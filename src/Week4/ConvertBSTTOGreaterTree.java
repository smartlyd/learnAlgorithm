package Week4;

import common.TreeNode;

/**
 * @author: Lee
 * @version: v1.0
 * @package: Week4
 * @description: Convert BST to Greater Tree leetcode 538
 * @date: 2021/10/31
 * @time: 4:03 下午
 * @link("https://leetcode-cn.com/problems/convert-bst-to-greater-tree/")
 */
public class ConvertBSTTOGreaterTree {
    private int pre;

    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        if (root == null) return root;
        dfs(root);
        return root;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        root.val += pre;
        pre = root.val;
        dfs(root.left);
    }
}
