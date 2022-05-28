//Given an m x n grid of characters board and a string word, return true if word exists in the grid.

//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

class Solution {
    public boolean exist(char[][] board, String word) {
        
        if(board.length*board[0].length==1 && word.length()==1) //Handling edge case if one character is present in the array with length of string 1
        {
            if(board[0][0]==word.charAt(0))
                return true;
        }
        
        List<String> set = new ArrayList<>();  //List to store all the occurence of first letter of given string
        FindFirst(board,set,word.charAt(0)); //Function to get all occurence of first letter
        boolean ans=false;
        for(String element : set)
        {
            int row=element.charAt(0)-'0';
            int col=element.charAt(1)-'0';
            boolean Cans = wordSearch(board,row,col,0,word); //Check the String exists or not
            ans=ans||Cans;
        }
        
        return ans;
    }
    boolean wordSearch(char[][] board,int row,int col,int ci,String s)
    {
        if(row<0||row>=board.length||col<0||col>=board[0].length)
            return false;
        
        if(ci==s.length())
            return true;
        
        if(board[row][col]=='.')
            return false;
        
        char CurrChar=board[row][col];
        if(board[row][col]==s.charAt(ci))
        {
            boolean up,down,left,right;
            board[row][col]='.'; //Marking the visited character
            up=wordSearch(board,row-1,col,ci+1,s);
            down=wordSearch(board,row+1,col,ci+1,s);
            right=wordSearch(board,row,col+1,ci+1,s);
            left=wordSearch(board,row,col-1,ci+1,s);
            board[row][col]=CurrChar;   //BackTracking
            return up||down||left||right;
        }
        else
            return false;
    }
    void FindFirst(char[][] board,List<String> ans,char c) //Find occurence of first character of string function
    {
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(board[i][j]==c)
                {
                    String Cans=i+""+j;;
                    ans.add(Cans);
                }
    }
}
