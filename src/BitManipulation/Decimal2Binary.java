package BitManipulation;

public class Decimal2Binary {
    public static void main(String[] args) {
        int n = 13;
        String s = "";
        while(n != 0)
        {
            if(n % 2 == 1) s = '1' + s;   // where we prepend each bit to the binary string, there's no need to reverse the string.
            else s = '0' + s;
            n = n/2;
        }
        System.out.println(s);
    }
}
