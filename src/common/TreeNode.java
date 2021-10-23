package common;

/**
 * @author: Lee
 * @version: v1.0
 * @package: common
 * @description: TODO
 * @date: 2021/10/23
 * @time: 6:24 下午
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
