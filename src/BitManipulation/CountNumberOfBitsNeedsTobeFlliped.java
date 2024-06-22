package BitManipulation;

public class CountNumberOfBitsNeedsTobeFlliped {
    public static void main(String[] args) {
        int start = 10;
        int goal = 7;
        int count = 0;

        int ans = (start ^ goal);
        while(ans > 0)
        {
            if((ans & 1) == 1) count++;
            ans = ans >> 1;
        }
        System.out.println(count);
    }
}
