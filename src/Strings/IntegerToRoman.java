package Strings;

public class IntegerToRoman {

    public static String intToRoman(int num)
    {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while(num > 0)
        {
            if(num >= values[i])
            {
                sb.append(romanNumerals[i]);
                num = num - values[i];
            }
            else
            {
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 3749;
        String roman = intToRoman(num);
        System.out.println(roman);
    }
}
