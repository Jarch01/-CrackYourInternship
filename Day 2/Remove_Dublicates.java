//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

//Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

//Return k after placing the final result in the first k slots of nums.
    
//LOGIC: Check the previous element is present or not, if present skip the element

class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;              
        int prev=nums[0];     //Record of previous element
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=prev)     //Checking if previous element is equal to current element
            {
                nums[k++]=nums[i]; //Kth element is initialised to current element
                prev=nums[i];      //Updating the previous element
            }
        }
        return k;
    }
}
