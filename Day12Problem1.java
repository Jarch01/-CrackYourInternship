//Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> answer = new ArrayList<>();
        int k=1; //Marker that stats where the zigzag takes place
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
            if(k==-1)
            Cans=reverse(Cans); //ZigZag when k = -1
            k=k*-1;
            answer.add(Cans);
        }
        return answer;
    }
    List<Integer> reverse(List<Integer> ans) //Reverse the list function;
    {
        List<Integer> answer = new ArrayList<>();
        for(int i=ans.size()-1;i>=0;i--)
            answer.add(ans.get(i));
        return answer;
    }
}
