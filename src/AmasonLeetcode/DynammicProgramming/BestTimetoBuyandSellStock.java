package AmasonLeetcode.DynammicProgramming;

/**
 * Created by yehuixiang on 7/15/18.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int[] profits = new int[prices.length];
        profits[0] = 0;
        for(int i = 1; i<prices.length;i++){
            profits[i] = prices[i]-prices[i-1];
        }

        int[] f = new int[profits.length];
        int global_max = profits[0];
        f[0] = profits[0];
        for(int i = 1;i<profits.length;i++){
            if(f[i-1]>0){
                f[i] = f[i-1]+profits[i];
            }else{
                f[i] = profits[i];
            }

            global_max = Math.max(global_max,f[i]);
        }

        return global_max;
    }

    public static void main(String[] args){
        int[] test1 = new int[]{7,1,5,3,6,4};
        int[] test2 = new int[]{7,6,4,3,1};

        BestTimetoBuyandSellStock bestTimetoBuyandSellStock = new BestTimetoBuyandSellStock();
        System.out.println(bestTimetoBuyandSellStock.maxProfit(test1));
        System.out.println(bestTimetoBuyandSellStock.maxProfit(test2));
    }
}
