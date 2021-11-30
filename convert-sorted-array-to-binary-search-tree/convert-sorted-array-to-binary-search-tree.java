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
 * Time complexity = O(N)
 * Space Complexity = O(height of tree)
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {        
        return dfsReconstruction(0, nums.length - 1, nums);
    }
    
    // pseudo code
    // start with 0 and end will be nums length
    // find the mid. BE CAREFUL HERE WITH right side of the array (end + start) / 2
    // recurse until start > end
    // recurse left tree from start to mid - 1
    // recurse right tree from mid + 1 to end.
    private TreeNode dfsReconstruction(int start, int end, int[] nums){
        if(start > end) {
            return null;
        }
        
        int mid = (end + start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfsReconstruction(start, mid - 1, nums);
        root.right = dfsReconstruction(mid+1, end, nums);
        return root;
    }
}