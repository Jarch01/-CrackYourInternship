class Solution {
    public int maxProduct(int[] nums) {
        int CurrMax = 1;
        int Max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++)   //Checking from left to right
        {
            CurrMax = CurrMax * nums[i];
            if(CurrMax > Max)
                Max = CurrMax;
            if(nums[i] > Max)
                Max = nums[i];
            if(CurrMax == 0)
                CurrMax = 1;
        }
        CurrMax = 1;
        for(int i= nums.length - 1; i>=0; i--)  //Checking from right to left
        {
            CurrMax = CurrMax * nums[i];
            if(CurrMax > Max)
                Max = CurrMax;
            if(nums[i] > Max)
                Max = nums[i];
            if(CurrMax == 0)
                CurrMax = 1;
        }
        return Max;
    }
}
