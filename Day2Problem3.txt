//You are given an array prices where prices[i] is the price of a given stock on the ith day.

//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

//Using DP
class Solution {
    public int maxProfit(int[] prices) {
        int ans=BuySell(prices,0,1,0,new HashMap<String,Integer>());  //HashMap to take values of over lapping sub problems
        return ans;
    }
    public int BuySell(int []p,int ci,int tran,int check,HashMap<String,Integer>memo)
    {
        if(ci==p.length)
            return 0;
        if(tran==0)      //No of transaction allowed becomes 0
            return 0;
        String key=ci+"-"+tran+"-"+check;
        if(memo.containsKey(key))
            return memo.get(key);
        int NoTrans=BuySell(p,ci+1,tran,check,memo);  //Incase of no transaction path
        int Trans;
        if(check==0)
            Trans=-p[ci]+BuySell(p,ci+1,tran,1,memo); // Substracted as money is given 
        else
            Trans=p[ci]+BuySell(p,ci+1,tran-1,0,memo); // Added as the stock is sold
        int Profit=Math.max(NoTrans,Trans);    //Maximum of two paths
        memo.put(key,Profit);
        return Profit;
    }
}
