//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

//Solving using Dutch National Flag Algorithm
class Solution {
    public void sortColors(int[] nums) {
        int low=0;                //indicating starting index of 0
        int high=nums.length-1;   //indicating starting index of 2
        int mid=0;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                nums[mid]=nums[low];  //swap the values if we get 0
                nums[low]=0;
                low++;                // increasing index to set it to next element
                mid++;                // increasing the mid to check the other element
            }
            else
                if(nums[mid]==1)
                    mid++;            // No need to swap skips when value is 1
            else
            {
                nums[mid]=nums[high];  // Swap the values if we get 2
                nums[high]=2;     
                high--;                //No need to increase mid as the swapped element may be 2
            }
        }
    }
}
