//Given an m x n board of characters and a list of strings words, return all words on the board.

//Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

//performing the word search function for each word of string

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<words.length;i++)
            if(WordSearch(board,words[i]))
                ans.add(words[i]);
        return ans;
    }
    public boolean isPresent(char[][] board,int row,int col,int ci,String s)
    {
        if(ci==s.length())
            return true;
        if(row<0||row>=board.length||col<0||col>=board[0].length)
            return false;
        if(board[row][col]=='.')
            return false;
        if(board[row][col]==s.charAt(ci))
        {
            char CurrChar = board[row][col];
            board[row][col]='.';
            boolean up = isPresent(board,row-1,col,ci+1,s);
            boolean down = isPresent(board,row+1,col,ci+1,s);
            boolean left = isPresent(board,row,col-1,ci+1,s);
            boolean right = isPresent(board,row,col+1,ci+1,s);
            board[row][col]=CurrChar;
            return up||down||left||right;
        }
        else
            return false;
    }
    public boolean WordSearch(char[][] board,String word)
    {
        int total = board.length*board[0].length;
        if(total==1 && word.charAt(0)==board[0][0] && word.length()==1)
            return true;
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
            {
                if(isPresent(board,i,j,0,word))
                    return true;
            }
        return false;
    }
}
