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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode ptr = head;
        int size = 0;
        while (ptr.next != null) {
            ptr = ptr.next;
            size += 1;
        }
        size += 1;
        ptr.next = head;
        for (int i = size - (k % size); i > 0; i--) {
            ptr = ptr.next;
        }
        head = ptr.next;
        ptr.next = null;
        return head;
    }
}