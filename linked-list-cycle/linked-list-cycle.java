/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(slow != fast) {
            
            if(fast.next == null || fast.next.next == null) {
                break;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow == fast;
    }
}