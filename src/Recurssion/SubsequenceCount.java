package Recurssion;

public class SubsequenceCount {

    public static int findSubsequences(int[] arr, int index, int sum, int target) {
        if (index == arr.length)
        {
            if (sum == target) return 1;
            return 0;
        }

        int include = findSubsequences(arr, index + 1, sum + arr[index], target);

        int exclude = findSubsequences(arr, index + 1, sum, target);

        return include + exclude;

    }

    public static int countSubsequencesWithSum(int[] arr, int target)
    {
        return findSubsequences(arr, 0, 0, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int sum = 2;
        int result = countSubsequencesWithSum(arr, sum);
        System.out.println("Number of subsequences with sum " + sum + ": " + result);
    }
}
