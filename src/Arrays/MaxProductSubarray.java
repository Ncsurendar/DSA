package Arrays;

public class MaxProductSubarray {
    public static void main(String[] args) {
        int [] arr = {2,3,-2,4};
        int n = arr.length;
        int prefix = 1, suffix = 1, max = 0,ans = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix = prefix * arr[i];
            suffix = suffix * arr[n-i-1];
            ans = Math.max(ans, Math.max(prefix,suffix));
        }
        System.out.println(ans);
    }
}
