package leetcode;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length==0||prices==null||prices.length==1)
            return 0;
        int buy=prices[0];
        int maxprofit=0;
        int profit=0;
        int sell=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<=buy) {
                buy = prices[i];
                sell=prices[i];
            }
            if(i+1<prices.length)
                if(prices[i+1]>=sell&&prices[i+1]>=buy) {
                    sell = prices[i + 1];
                    profit = sell - buy;
                }
                if(profit>maxprofit)
                    maxprofit=profit;
        }
        return maxprofit;
    }
}
