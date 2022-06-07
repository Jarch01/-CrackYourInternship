//Using the right limit and left limit for each element
//Using stack to get the left and right limit 
//Since the largest rectangle consists of a entire bar and the x axis direction will be different
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int leftlimit[] = new int[n];
        int rightlimit[] = new int[n];
        stack.push(0);
        for(int i=1; i<n; i++)
        {
            if(stack.isEmpty())
            {
                leftlimit[i]=0;
                stack.push(i);
            }
            else
            {
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                    leftlimit[i]=0;
                else
                    leftlimit[i]=stack.peek()+1;
                stack.push(i);
            }
        }
        
        while(!stack.isEmpty())
            stack.pop();
        
        for(int i=n-1; i>=0; i--)
        {
            if(stack.isEmpty())
            {
                rightlimit[i]=n-1;
                stack.push(i);
            }
            else
            {
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                    rightlimit[i]=n-1;
                else
                    rightlimit[i]=stack.peek()-1;
                stack.push(i);
            }
        }
        int ans=0;
        for(int i=0; i<n; i++)
        {
            int x = rightlimit[i] - leftlimit[i] + 1;
            int y = heights[i];
            ans = Math.max(ans,x*y);
        }
        return ans;
    }
}
