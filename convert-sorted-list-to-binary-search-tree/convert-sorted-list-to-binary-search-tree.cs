/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
* 
*
**/
public class Solution {
    private ListNode trackingNode;
    public TreeNode SortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode temprunner = head;
        trackingNode = head;

        int size = 0;
        while(temprunner != null) {
            temprunner = temprunner.next;
            ++size;
        }

        return ConvertToBSTInternal(0, size - 1);
    } 

    private TreeNode ConvertToBSTInternal(int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = start + ((end - start) / 2);
        TreeNode leftTree = ConvertToBSTInternal(start, mid - 1);

        TreeNode currentNode = new TreeNode(trackingNode.val);
        currentNode.left = leftTree;
        trackingNode = trackingNode.next;
        
        currentNode.right = ConvertToBSTInternal(mid + 1, end);

        return currentNode;
    }
}