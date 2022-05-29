//Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)   //If head is null then return null
            return head;
        ListNode temp = head; //Using two pointers
        ListNode prev = head;
        while(temp!=null)
        {
            if(prev.val==temp.val) //if value remains same then temp keeps on moving
                temp=temp.next;
            else
            {
                prev.next=temp;   //If prev value is not temp value then the prev pointer points to temp
                prev=prev.next;
            }
        }
        prev.next=temp;  //If the duplicate is upto the end of list, prev points to the null
        return head ;
    }
}
