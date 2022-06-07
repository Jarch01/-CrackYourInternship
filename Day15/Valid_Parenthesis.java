class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++)
        {
            char chr = s.charAt(i);
            if(chr=='(' || chr=='[' || chr=='{')
                stack.push(chr);
            else
            {
                if(stack.isEmpty())
                    return false;
                char check = stack.pop();
                if(chr==')' && check!='(')
                    return false;
                if(chr=='}' && check!='{')
                    return false;
                if(chr==']' && check!='[')
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
