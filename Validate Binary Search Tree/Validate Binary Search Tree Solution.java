/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {

        long nodeMinRange = (long)(Integer.MIN_VALUE)-1;
        long nodeMaxRange = (long)(Integer.MAX_VALUE)+1;

        boolean isValidBST = checkValidBST(root, nodeMinRange, nodeMaxRange);
        return isValidBST;
        
    }

    public boolean checkValidBST(TreeNode root, long nodeMinRange, long nodeMaxRange){
        if(root == null){
            return true;
        }

        if(root.val <= nodeMinRange || root.val >= nodeMaxRange){
            return false;
        }

        boolean leftNode = checkValidBST(root.left, nodeMinRange, (long) root.val);
        if(leftNode == false){
            return false;
        }

        boolean rightNode = checkValidBST(root.right, (long)root.val, nodeMaxRange);
        if(rightNode == false){
            return false;
        }

        return leftNode && rightNode;
    }
}