//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

class Solution {
    public int minPathSum(int[][] grid) {
        int a[][] = new int[grid.length][grid[0].length];
        a=Initialise(a);
        int ans=MinSum(grid,0,0,a);
        return ans;
    }
    public int MinSum(int[][] grid,int row,int col,int [][] a)
    {
        if(row==grid.length||col==grid[0].length)
            return 20000001;
        if(row==grid.length-1&&col==grid[0].length-1) //Target grid reached
            return grid[row][col];
        if(a[row][col]!=-1)
            return a[row][col];
        int right=grid[row][col]+MinSum(grid,row,col+1,a); //Path for right movement
        int down=grid[row][col]+MinSum(grid,row+1,col,a);  //Path for down movement
        int ans=Math.min(right,down);
        a[row][col]=ans;
        return ans;
    }
    public int[][] Initialise(int[][] a)
    {
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
                a[i][j]=-1;
        }
        return a;
    }
}
