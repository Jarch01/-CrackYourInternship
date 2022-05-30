//Given the head of a singly linked list, reverse the list, and return the reversed list.

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode Curr = head;
        ListNode prev = null;
        ListNode Next;
        while(Curr!=null) //Three pointer to reverse linked list
        {
            Next=Curr.next;  //Next pointer is updated to Next pointer of current
            Curr.next=prev;  //Reversing the node 
            prev=Curr; //Updating the prev as current node
            Curr=Next; //Updating the current node to next
        }
        head=prev; //Head is updated to prev as now the linkedlist is reversed
        return head;
    }
}
