class Solution{
    class SubTree{   //Custom Class to Store the parameters of each root object
        int size;
        int Maxval;
        int Minval;
        boolean BST;
        
        SubTree(int size, int MaxVal,int MinVal,boolean BST)   //Functions to initialise the parameters
        {
            this.size=size;
            this.Maxval=MaxVal;
            this.Minval=MinVal;
            this.BST=BST;
        }
        
        SubTree(int size,boolean BST)
        {
            this.size=size;
            this.BST=BST;
        }
    }
    
    // Return the size of the largest sub-tree which is also a BST
     int largestBst(Node root)
    {
        // Write your code here
        return FindBST(root).size;
    }
     SubTree FindBST(Node root)
    {
        if(root==null)
        return new SubTree(0,0,10000000,true);    //if null encounter object returns size 0 max value 0 min value MAX and true as it is a BST
        
        if(root.left==null && root.right==null)
        return new SubTree(1,root.data,root.data,true);  //if leaf is encounter object return size 1 max value leaf value min value leaf value and true as it is a BST
        
        SubTree Left=FindBST(root.left);
        SubTree Right=FindBST(root.right);
        
        if(Left.BST && Right.BST && root.data>Left.Maxval && root.data<Right.Minval)  //If current root is a BST
        {
            int Max=Math.max(root.data,Right.Maxval);
            int Min=Math.min(root.data,Left.Minval);
            int l=Left.size+Right.size+1;
            return new SubTree(l,Max,Min,true); //Returning the new value
        }
        else
        return new SubTree(Math.max(Left.size,Right.size),false);  //Return false if its not BST
    }
}
