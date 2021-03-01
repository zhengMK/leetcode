// The recursive approach.
// Remember to return the head of the sub-list to its previous node (i.e. ptr.next.next = helper(ptr.next.next))
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }
    private ListNode helper(ListNode ptr) {
        if (ptr == null || ptr.next == null) return ptr;
        ListNode temp = ptr;
        ptr = ptr.next;
        temp.next = ptr.next;
        ptr.next = temp;
        ptr.next.next = helper(ptr.next.next);
        return ptr;
    }
}