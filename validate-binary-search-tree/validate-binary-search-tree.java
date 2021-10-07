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
        if(root == null) {
            return false;
        }    
        
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        
        returnSorted(sortedList, root);
        for(int i = 0; i < sortedList.size() - 1; i++) {
            if(sortedList.get(i) >= sortedList.get(i + 1)) {
                return false;
            }
            
        }
        
        return true;
    }
    
    private void returnSorted(ArrayList<Integer> sortedList, TreeNode node) {
       if(node == null) {
           return;
       } 
        
        returnSorted(sortedList, node.left);
        sortedList.add(node.val);
        returnSorted(sortedList, node.right);
    }
    
}