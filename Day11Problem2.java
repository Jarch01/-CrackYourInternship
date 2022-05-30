//Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1!=temp2)
        {
            if(temp1==null)   //Temp Node of A is placed to B to cover the extra length of B
                temp1=headB;
            else
                temp1=temp1.next;
            
            if(temp2==null)   ////Temp Node of B is placed to A to cover the extra length of A
                temp2=headA;
            else
                temp2=temp2.next;
        }
        return temp1;
    }
}
