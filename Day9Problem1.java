//Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

class Solution {
    public int maximalSquare(char[][] matrix) {
        int area=0;
        HashMap<String,Integer> memo = new HashMap<>(); //HashMap to store answers of overlapping sub problems
        
        for(int i=0;i<matrix.length;i++)        //We need to check for every element as some cases may appear where the max is found very below
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]=='1')
                {
                    int len=MaxSq(matrix,i,j,memo);
                    area=Math.max(area,len*len);     //Maximum of all the squares
                }
            }
        
        return area;
    }
    public int MaxSq(char[][] grid,int row,int col,HashMap<String,Integer> memo)
    {
        if(row==grid.length||col==grid[0].length) //Out of the grid
            return 0;
        if(grid[row][col]=='0')  //If the value is zero
            return 0;
        
        String key=row+"-"+col;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int down=1+MaxSq(grid,row+1,col,memo);  //Length Calculation
        int right=1+MaxSq(grid,row,col+1,memo); //Breadth Calculation
        int diagonal=1+MaxSq(grid,row+1,col+1,memo); //Diagonal musrt also contains 1
        
        memo.put(key,(Math.min(diagonal,Math.min(right,down))));
        return memo.get(key);
    }
}
