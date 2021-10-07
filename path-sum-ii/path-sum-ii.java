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
import java.util.List;
class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //edge cases of 0
        // edge case of no nodes
        // can have positive and negative numbers. Hence have to explore all. 
        
        // solution 1, simple traversal and explore all nodes O(N)
        //pseudo code:
        // BFS may be a better solution
        // 1. Keep track of current sum
        // 2. keep track of current path
        // 3. If hit leaf and current sum == total sum, record and add to final array
        // 4. if not do not add to final array and return
        
        if(root == null) {
            return result;
        }
     
        getPaths(0, targetSum, root, new ArrayList<Integer>());
        return result;
    }
    
    private void getPaths(int currentSum, int targetSum, TreeNode root, List<Integer> currentPath) 
    {
        if(root.left == null && root.right == null) {
            if(currentSum + root.val == targetSum) {
                currentPath.add(root.val);
                result.add(new ArrayList<Integer>(currentPath));
                currentPath.remove(currentPath.size() - 1);
            } 
            
            return;
        }
        
        currentPath.add(root.val);
        
        if(root.left != null) {
            getPaths(currentSum + root.val, targetSum, root.left, currentPath);    
        }

        if(root.right != null) {
            getPaths(currentSum + root.val, targetSum, root.right, currentPath);    
        }        
        
        currentPath.remove(currentPath.size() - 1);
    }
}