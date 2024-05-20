package Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int [] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int n = arr.length;
        int left = 0, right = n-1,res = 0;
        int leftMax = 0, rightMax = 0;

        while(left <= right)
        {
            if(arr[left] <= arr[right])
            {
                if(arr[left] >= leftMax)
                {
                    leftMax = arr[left];
                }
                else
                {
                    res += leftMax - arr[left];
                }
                left++;
            }
            else
            {
                if(arr[right] >= rightMax)
                {
                    rightMax = arr[right];
                }
                else
                {
                    res += rightMax - arr[right];
                }
                right--;
            }
        }

        System.out.println(res);
    }
}
