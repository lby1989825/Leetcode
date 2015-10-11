package BinaryTreeUpsideDown;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
    	TreeNode p =root, parent = null, parentRight = null;
    	while(p != null) {
    		TreeNode left = p.left;
    		p.left = parentRight;
    		parentRight = p.right;
    		p.right = parent;parent = p;
    		p = left;
    		}
    	return parent;
    }
}
