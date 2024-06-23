package BitManipulation;

public class SingleNumber3 {

    public static int[] singleNumber(int[] nums)
    {
        int xor = 0;
        for(int i=0; i<nums.length; i++)
        {
            xor = xor ^ nums[i];
        }
        int rightMostBit = xor & -xor;
        int b1 = 0;
        int b2 = 0;
        for(int i=0; i<nums.length; i++)
        {
            if((nums[i] & rightMostBit) == 0) b1 =  b1 ^ nums[i];
            else b2 = b2 ^ nums[i];
        }

        return new int[]{b1, b2};
    }

    public static void main(String[] args) {
        int []nums = {1, 2, 1, 3, 2, 5};
        int [] result = singleNumber(nums);
        System.out.println("The two unique numbers are: " + result[0] + " and " + result[1]);
    }
}
