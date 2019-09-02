public class maxProfit {
    public int maxProfit(int[] prices){
        if(prices.length == 0) return 0;

        int minInput = prices[0];
        int ans = 0;
        for(int price:prices){
            minInput = Math.min(minInput,price);
            ans = Math.max(ans,price-minInput);
        }
        return ans;
    }
}
