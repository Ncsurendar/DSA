package Arrays;

public class MissingAndRepeating {

    public static int[] findMissingRepeatingNumber(int [] arr)
    {
        int n = arr.length;
        int missing = -1, repeating = -1;
        int count = 0;
        for(int i=1; i<=n; i++)
        {
            count = 0;
            for(int j=0; j<n; j++)
            {
                if(arr[j] == i) count++;
            }
            if(count == 2) repeating = i;
            else if(count == 0) missing = i;
            if(repeating != -1 && missing != -1) break;
        }
        int [] ans = {missing, repeating};
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {3,1,2,5,4,6,7,5};
        int [] ans = findMissingRepeatingNumber2(arr);
        System.out.println("{"+ ans[0]+" is missing" + ", " + ans[1]+" is repeating"+"}");
    }

    public static int[] findMissingRepeatingNumber2(int[] arr) {
        long n = arr.length;
        long SumOfNaturalNumbers = (n * (n + 1)) / 2;
        long SumOfSquareOfNaturalNumbers = (n * (n + 1) * (2 * n + 1)) / 6;
        long Sum1 = 0, Sum2 = 0;
        for (int i = 0; i < n; i++) {
            Sum1 += arr[i];
            Sum2 += (long)arr[i] * (long)arr[i];
        }
        long val1 = Sum1 - SumOfNaturalNumbers;
        long val2 = Sum2 - SumOfSquareOfNaturalNumbers;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;
        int[] ans = {(int)y, (int)x};
        return ans;
    }
}
