//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rowset = new HashSet<>(); //Set to store data of the row to be zero
        HashSet<Integer> colset = new HashSet<>(); //Set to store data of the column to be zero
        
        for(int i=0;i<matrix.length;i++)   //Traversing in O(M*N)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    if(!rowset.contains(i))  //Adding the row to rowset if not present
                        rowset.add(i);
                    if(!colset.contains(j))  //Adding the column to colset if not present
                        colset.add(j);
                }
            }
        }
        for(int row : rowset)
        {
            for(int j=0;j<matrix[0].length;j++)  
                matrix[row][j]=0; //Traversing in rowset to set all elements in the row to zero
        }
        for(int col : colset)
        {
            for(int i=0;i<matrix.length;i++)
                matrix[i][col]=0; //Traversing in colset to set all elements in the column to zero
        }
    }
}
