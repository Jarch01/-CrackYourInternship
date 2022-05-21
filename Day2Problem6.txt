//You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

//On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

//Find and return the maximum profit you can achieve.

//Using DP
class Solution {
    public int maxProfit(int[] prices) {
        int ans = BuyAndSell(0,false,prices,new HashMap<String,Integer>());
        return ans;
    }
    public int BuyAndSell(int ci,boolean Bought,int[] price,HashMap<String,Integer> memo)
    {
        if(ci==price.length) //return the value if array ended
            return 0;
        
        String key = ci+"-"+Bought;  //Creating a key for the overlapping sub problem
        if(memo.containsKey(key))
            return memo.get(key);
        
        int Notrans=BuyAndSell(ci+1,Bought,price,memo); //Path for no transaction
        
        int Trans=0;
        if(Bought==false)
            Trans=-price[ci]+BuyAndSell(ci+1,true,price,memo); //Path for buying
        else
            Trans=price[ci]+BuyAndSell(ci+1,false,price,memo); //Path for selling
        
        int ans = Math.max(Trans,Notrans); //returning the answer as the max of the Paths
        memo.put(key,ans);
        return ans;
    }
}
