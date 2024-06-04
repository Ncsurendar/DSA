package Strings;

public class MobileNumbericKeypadSequence {

    public static String printSequence(String s)
    {
        String [] arr = {"2","22","222","3","33","333","4","44","444","5","55","555","6","66","666","7","77","777","7777","8","88","888","9","99","999","9999"};
        String res = "";
        for(char a: s.toCharArray())
        {
            if(a == ' ') res += 0;
            else
            {
                int index = a - 'A';
                res += arr[index];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "HEY U";
        String ans = printSequence(s);
        System.out.println(ans);
    }
}
