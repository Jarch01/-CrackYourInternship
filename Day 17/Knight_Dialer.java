class Solution {
    public int knightDialer(int k) {
        int m = 3;
        int n = 4;
        int ans = 0;
        int[][][] memo = new int[n+1][m+1][k+1];
        int MOD = 1000000007;
        Fill(memo);
        
        //Unavaiable coordinates [4][1] and [4][3]
        for(int row=1; row<=n; row++)
            for(int col=1; col<=m; col++)
            {
                int Cans = AllMoves(row,col,k,m,n,memo);
                ans = (ans % MOD + Cans % MOD ) % MOD;
            }
        return ans;
    }
    public int AllMoves(int row,int col,int k,int m,int n,int[][][] memo)
    {
        if(row<1 || row>n || col<1 || col>m)
            return 0;
        if((row==4 && col==1) || (row==4 && col==3))
            return 0;
        if(k==1)
            return 1;
        
        if(memo[row][col][k]!= -1)
            return memo[row][col][k];
        
        int MOD = 1000000007;
        int upleft = AllMoves(row-2,col-1,k-1,m,n,memo);
        int upright = AllMoves(row-2,col+1,k-1,m,n,memo);
        int leftup = AllMoves(row-1,col-2,k-1,m,n,memo);
        int leftdown = AllMoves(row+1,col-2,k-1,m,n,memo);
        int downleft = AllMoves(row+2,col-1,k-1,m,n,memo);
        int downright = AllMoves(row+2,col+1,k-1,m,n,memo);
        int rightdown = AllMoves(row+1,col+2,k-1,m,n,memo);
        int rightup = AllMoves(row-1,col+2,k-1,m,n,memo);
        int ans1 = (upleft% MOD + upright% MOD) % MOD;
        int ans2 = (leftdown% MOD + leftup% MOD) % MOD;
        int ans3 = (downleft% MOD + downright% MOD) % MOD;
        int ans4 = (rightdown% MOD + rightup% MOD) % MOD;
        int ans = ((ans1% MOD + ans2% MOD)%MOD + (ans3% MOD + ans4% MOD)%MOD) % MOD;
        
        memo[row][col][k] = ans;
        return ans;
    }
    public void Fill(int[][][] memo)
    {
        for(int i=0;i<memo.length;i++)
            for(int j=0;j<memo[0].length;j++)
                for(int k=0;k<memo[0][0].length;k++)
                    memo[i][j][k] = -1;
    }
}
