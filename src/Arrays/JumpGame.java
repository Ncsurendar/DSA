package Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int [] arr = {2,3,1,1,4};
        int stepLeft = arr[0];
        for(int i=1; i<arr.length; i++)
        {
            stepLeft--;
            if(stepLeft < 0) System.out.println("False");
            if(i == arr.length-1) System.out.println("True");
            if(stepLeft < arr[i])
            {
                stepLeft = arr[i];
            }
        }

    }
}
