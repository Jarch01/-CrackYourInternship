//Given the head of a linked list, remove the nth node from the end of the list and return its head.

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)  //Avoid edge case
            return head;
        
        int a[] = {n};
        remove(head,a); //Passing array as reference for the number of nodes
        
        if(a[0]==0) //Returning from the remove function if the first node is to remove
            head=head.next;
        
        return head;
    }
    public void remove(ListNode Curr,int [] a)
    {
        if(Curr==null)
            return ;
        remove(Curr.next,a);
        //Updating the value of a[0] after returning
        if(a[0]==0) //If the previous node of the removable node is encounter
        {
            ListNode temp = Curr.next.next; 
            Curr.next = temp;
        }
        a[0]--;  //Post decrement to get the previous node of removed node
        return ;
    }
}
