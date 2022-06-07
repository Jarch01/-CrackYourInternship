// Problem : Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

// There is only one repeated number in nums, return this repeated number.

class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length+1;
        for(int i=0;i<nums.length;i++)
        {
            int val=nums[i]%n; //Since all values in range 1 to N
            nums[val]=nums[val]+n; //Converting to a new element for frequency count
        }
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]/n>1) //Checking frequency of each element
                ans=i;
            nums[i]=nums[i]%n; //Converting the array to original array
        }
        return ans;           
    }
}
