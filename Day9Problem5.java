class Solution {
    public List<List<String>> solveNQueens(int n) { 
    
    List<List<String>> res = new ArrayList<>();
    
    char[][] board = new char[n][n];
    
    for (int i=0; i<n; i++)      //Initialising the character array with '.'
        for(int j=0; j<n; j++)
            board[i][j] = '.';
    
    solve(0 , board , res);
    
    return res;
}

public boolean isSafe(char[][] board , int row, int col){
    
    for(int i = 0; i<row + 1; i++) //Same Row
        if(board[i][col] == 'Q')
            return false;
    
    int r = row, c = col;
    while(r>=0 && c>=0){ //Left Top Diagnoal
        if (board[r][c] == 'Q')
            return false;
        r--;
        c--;
    }
    
    r = row; c = col;
    while(c < board.length && r>=0){ //Left Bottom Diagonal
        if(board[r][c] == 'Q')
            return false;
        c++;
        r--;
    }
    
    return true; 
}

public void solve(int row , char[][] board , List<List<String>> res){
    
    if(row == board.length){ 
        res.add(construct(board)); 
        return ;
    }
    
    for (int col=0; col<board.length; col++){
        if(isSafe(board , row , col)){  //Checking validity then placed queen
            board[row][col] = 'Q'; 
            solve(row + 1, board , res); 
            board[row][col] = '.';  //Back Tracking
        }
    }
}
     public List<String> construct(char[][] board){ 
    
    List<String> res = new ArrayList<>();
    
    for (int i=0; i<board.length; i++){
        String str = new String(board[i]); 
        res.add(str); 
    }
    
    return res; 
}
}
