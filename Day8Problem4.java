//Game of life leetcode problem

//Suppose a number ab where a is 1st digit and b is second digit
//a represents the changed value and b represents the unchanged value

class Solution {
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        for(int row=0;row<n;row++)
        {
            for(int col=0;col<m;col++)
            {
                //Getting value of each adjacent neighbours
                int n1=getValue(row-1,col-1,n,m,board);
                int n2=getValue(row-1,col,n,m,board);
                int n3=getValue(row-1,col+1,n,m,board);
                int n4=getValue(row+1,col-1,n,m,board);
                int n5=getValue(row+1,col,n,m,board);
                int n6=getValue(row+1,col+1,n,m,board);
                int n7=getValue(row,col-1,n,m,board);
                int n8=getValue(row,col+1,n,m,board);
                
                //Summation to get the number of cells alive
                int sum=n1+n2+n3+n4+n5+n6+n7+n8;
                
                if(sum<2)   //If less than two alive
                    board[row][col]=(board[row][col]%10)+0;  //Changed value 0 unchanged value prev val
                
                if(sum>3)  //If more than three alive
                    board[row][col]=(board[row][col]%10)+0;  //Changed value 0 unchanged value prev val
                
                if(sum==2&&board[row][col]==1)  //If exactly two alive and cell itselt is alive
                    board[row][col]=10+board[row][col]%10;  //Changed value 1 unchanged value prev val
                
                if(sum==3)   //If exactly three neighbours are alive
                    board[row][col]=(board[row][col]%10)+10;  //Changed value 1 unchanged value prev val
            }
        }
        Convert(board);
        return ;
    }
    public int getValue(int row,int col,int n,int m,int[][] board) //Get value function to return thr previous or original value
    {
        if(row<0||row>=n||col<0||col>=m)
            return 0;
        return board[row][col]%10;
    }
    void Convert(int[][] a) //Function to change the combined values into the new values
    {
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                a[i][j]=a[i][j]/10;
    }
}
