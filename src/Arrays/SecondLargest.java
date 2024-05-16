package Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int [] arr = {50,10,90,20,80};
        int max=Integer.MIN_VALUE, secondMax=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] > max)
            {
                secondMax = max;
                max = arr[i];
            }
            else if(arr[i] < max && arr[i] > secondMax)
            {
                secondMax = arr[i];
            }
        }
        System.out.println(secondMax);
    }
}
