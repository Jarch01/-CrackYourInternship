//Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

//Pattern noticed : 0 1 10 11 
//For every power 2 element : previous ref index + 1
// n(3) = n(1)+1
class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        ans[0]=0;
        int k=0,limit=2;
        for(int i=1;i<=n;i++)
        {
            ans[i]=ans[k++]+1; //Implementing the pattern
            if(i+1==limit)
            {
                k=0;
                limit=limit*2;
            }
        }
        return ans;
    }
}
