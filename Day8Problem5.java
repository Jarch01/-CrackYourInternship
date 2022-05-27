/*A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int a[] = new int[1];
        a[0]=-300000001; //Initialising answer to lowest value
        int k = Max(root,a);
        return a[0];
    }
    public int Max(TreeNode root,int[] ans)
    {
        if(root==null)
            return 0;
        int left = Math.max(Max(root.left,ans),0);  //Consider only when the value is not negative
        int right = Math.max(Max(root.right,ans),0);//Consider only when the value is not negative
        
        if(ans[0]<left+right+root.val) //Updating the answer if the total value is more than the answer
            ans[0]=left+right+root.val;
        
        return root.val+Math.max(left,right); //returning the max of left and right child with root
    }
}
