class Solution {
    public int findPeakElement(int[] nums) {
        int high = nums.length - 1;
        int low = 0;
        for(int i=1; i<nums.length-1; i++)
        {
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
                return i;
        }
        if(nums[low]<nums[high])
            return high;
        else
            return low;
    }
}
