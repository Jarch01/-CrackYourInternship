//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//Rain Water Trapping

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];
        int[] leftMax = new int[n];
        int max=0;
        for(int i=0;i<n;i++) //LeftMax at each index
        {
            if(max<height[i])
                max=height[i];
            leftMax[i]=max;
        }
        max=0;
        for(int i=n-1;i>=0;i--) //Right Max at each index
        {
            if(max<height[i])
                max=height[i];
            rightMax[i]=max;
        }
        int ans=0;
        for(int i=0;i<n;i++)
            ans=ans+Math.min(leftMax[i],rightMax[i])-height[i];  //Water collected is water available to coollect - height
        return ans;
    }
}
