class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int frontAns = 0;
        int right,left;
        
        for(right=0; right<k; right++)
            frontAns = frontAns + cardPoints[right];
        
        int ans = frontAns;
        int backAns = 0;
        
        for(left=n-1; left>=n-k; left--)
        {
            backAns = backAns + cardPoints[left];
            frontAns = frontAns - cardPoints[--right];
            
            int CurrAns = frontAns + backAns;
            ans = Math.max(ans,CurrAns);
        }
        
        return ans;
    }
}
