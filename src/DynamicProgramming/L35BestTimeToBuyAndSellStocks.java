package DynamicProgramming;

public class L35BestTimeToBuyAndSellStocks {

    static int maxProfit(int[] arr)
    {
        int profit = 0, mini = arr[0];
        for(int i=1; i<arr.length; i++)
        {
            int cost = arr[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, arr[i]);
        }

        return profit;
    }


    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
