//SUDOKU SOLVER
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
    
    public boolean backtrack(char[][] board)
    {
        //checking for every char
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                //finding empty cell
                if(board[i][j]=='.')
                {
                    
                    //check for placing values from 1 to 9
                    for(char v='1';v<='9';v++)
                    {
                        //if it's valid to put then set the value
                        if(isValid(v,i,j,board)==true)
                        {
                            board[i][j]=v;
                            //check for other empty space for placing value
                            if(backtrack(board)==true)
                                return true; //if the board is solved
                            else
                                board[i][j]='.'; //if board is not solved , try to check for next value,so remove the prev value that we added
                        }
                    }
                    //if we can not fit any value that means our decision for choosing and filling prev empty space is wrong so return false
                    return false;
                }
            }
        }
        
        return true;// sudoku solved
    }
    
    public boolean isValid(char c, int row, int col, char[][] board)
    {
        for(int i=0;i<9;i++)
        {
            //checking in col
            if(board[i][col]==c)
                return false; 
            
            //checking in row
            if(board[row][i]==c)
                return false;
            
            //checking in a square
            if(board[3*(row/3)+i/3][3*(col/3) + i%3]==c)
                return false;
        }
        
        return true;
    }
    
}
