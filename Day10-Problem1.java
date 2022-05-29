/*You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.*/

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int len = grid.length*grid[0].length; //Total number of grids present
        int obs = NoOfObs(grid);   //Finding the obstrucles 
        int a[] = new int[2];
        getStart(grid,a);  //Finding the starting grid
        int row=a[0];
        int col=a[1];
        int ans = AllPaths(grid,row,col,len-obs-1); //We need to cover all the grids except the starting and obstrucles
        return ans;
    }
    public int AllPaths(int [][] grid,int row,int col,int len)
    {
        if(row<0||row>=grid.length||col<0||col>=grid[0].length)
            return 0;
        if(grid[row][col]==2 && len==0)  //If all the grids are covered and end is reached
            return 1;
        if(grid[row][col]==-1) //If Path has obstrucles
            return 0;
        if(grid[row][col]==4) //For Backtracking
            return 0;
        int Curr=grid[row][col];
        grid[row][col]=4;
        int up = AllPaths(grid,row-1,col,len-1);
        int down = AllPaths(grid,row+1,col,len-1);
        int left = AllPaths(grid,row,col-1,len-1);
        int right = AllPaths(grid,row,col+1,len-1);
        grid[row][col]=Curr;  //BackTracking
        return up+down+left+right;
    }
    public int NoOfObs(int[][] grid)  //Function to find the total number of obstrucles
    {
        int s=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]==-1)
                    s++;
        return s;
    }
    public void getStart(int[][] grid,int[] ans)  //Function to find starting grid
    {
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]==1)
                {
                    ans[0]=i;
                    ans[1]=j;
                    return ;
                }
    }
}
