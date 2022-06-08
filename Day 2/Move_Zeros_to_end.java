//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

class Solution {
    public void moveZeroes(int[] nums) {
        int c=0;            
        for(int i=0;i<nums.length;i++)    //counting elements equal to 0
            if(nums[i]==0)
                c++;
        int k=0;
        for(int i=0;i<nums.length;i++)   //Shifting all characters forward
        {
            if(nums[i]!=0)
                nums[k++]=nums[i];
        }
        while(k<nums.length)   //initialising rest elements to 0
        {
            nums[k++]=0;
        }
    }
}
