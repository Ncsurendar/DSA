package Arrays;

public class BestTimeToBuyStocks {
    public static void main(String[] args) {
        int [] arr = {7,1,5,3,6,4};
        int min = arr[0],profit = 0;
        for(int i=1; i<arr.length; i++)
        {
            min = Math.min(min, arr[i]);
            profit = Math.max(profit, arr[i] - min);
        }
        System.out.println(profit);
    }
}
