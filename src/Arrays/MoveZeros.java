package Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int [] arr = {1,0,2,3,2,0,0,4,5,1};
        int j = -1;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == 0)
            {
                j = i;
                break;
            }
        }

        for(int i=j+1; i<arr.length; i++)
        {
            if(arr[i] != 0)
            {
                arr[i] = arr[i]+arr[j]-(arr[j]=arr[i]);
                j++;
            }
        }

        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

}
