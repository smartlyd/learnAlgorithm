package Week3;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;


/**
 * @author: Lee
 * @version: v1.0
 * @package: Week3
 * @description: leetcode 106. 从中序与后序遍历序列构造二叉树
 * @date: 2021/10/23
 * @time: 6:19 下午
 * @link(https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
 */
public class InorderAndPostorder {


    int[] inorder;
    int[] postorder;
    int rootVal;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        rootVal = postorder.length - 1;
        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        return build(0, inorder.length - 1);
    }

    //都用中序处理
    //子树的左右边界
    private TreeNode build(int left, int right) {
        if (left > right) return null;
        //确认根节点
        TreeNode root = new TreeNode(postorder[rootVal]);
        //通过根节点位置拆分左右子树
        int index = idx_map.get(postorder[rootVal]);
        rootVal--;
        root.right = build(index + 1, right);
        root.left = build(left, index - 1);
        return root;
    }
}
