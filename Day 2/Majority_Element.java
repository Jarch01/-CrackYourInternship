//Given an array nums of size n, return the majority element.

//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

//Using Moore Majority Element Algorithm

class Solution {
    public int majorityElement(int[] nums) {
        int c=0,element=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(c==0)
            {
                element=nums[i];   //Selecting a majority element
                c=0;
            }
            if(element==nums[i])    //Checking the frequency of the majority element selected
                c++;
            else
                c--;
        }
        int check=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==element)   //Counting the frequency of the majority element selected
                check++;
        }
        if(check>nums.length/2)  //Checking whether it is more than n/2
            return element;
        else
            return -1;      //If the element is not majority
    }
}
