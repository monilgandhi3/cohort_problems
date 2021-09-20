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

    /**
    * 1. Find the size of the list
    * 2. This is very similar to inorder traversal. 
    TIP if you want to get a sorted order from a Binary Search tree, use inorder traversal. This list represents inorder traversed tree
    * 3. We do inorder traversal from start to end
    * 4. Base condition will be when start > end return null. 
    * 5. At every step our start and end keep getting closer. We do this by dividing the list into left and right subtree by calculating mid
    * 6. For mid we need actual index. hence it will always be with respect to start i.e. start + ((end - start) / 2)
    * 7. The left tree is everything from start, mid -1 and right subtree is mid+1 to end.
    * 8. Remember to move the tracking node which will point to the current node in linked list.
    *
    * Time Complexity will be O(N) to traverse all the nodes
    * Space complexity will be O(N) + O(N). O(N) is for the tree nodes and O(N) is for the space of the stack for building left and right subtree.
    */

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