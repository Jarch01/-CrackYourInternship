//Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        
        if(root==null)
            return answer;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> Cans = new ArrayList<>();
            
            while(size>0)  //Level order traversal at each level
            {
                TreeNode ans = queue.remove();
                Cans.add(ans.val);
                if(ans.left!=null)
                    queue.add(ans.left);
                if(ans.right!=null)
                    queue.add(ans.right);
                
                size--;
            }
            answer.add(Cans); //Add the nodes into answer
        }
        
        return answer;
    }
}
