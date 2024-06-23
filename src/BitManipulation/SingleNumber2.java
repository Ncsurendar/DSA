package BitManipulation;

public class SingleNumber2 {

    public static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for(int i=0; i<nums.length; i++)
        {
            ones = ones ^ (nums[i] & ~twos);
            twos = twos ^ (nums[i] & ~ones);
        }

        return ones;
    }

    public static void main(String[] args) {
        int [] nums = {2,2,3,2};
        System.out.println(singleNumber(nums));
    }
}
