package BitManipulation;

public class CheckifithBitisSetOrNot {
    public static void main(String[] args) {
        int n = 4;
        int k = 0;                //  Check if the given kth bit is 1 or not. So we use shifting to bring it to front and do and operation
        if(((n >> k) & 1) == 1) System.out.println(true);
        else System.out.println(false);
    }
}
