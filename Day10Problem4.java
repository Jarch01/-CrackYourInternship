//Given the head of a singly linked list, return the middle node of the linked list.

//If there are two middle nodes, return the second middle node.

//Using slow and fast pointer approach
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) //Fast will reach the end first
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow; //When fast reaches end slow is on the middle
    }
}
