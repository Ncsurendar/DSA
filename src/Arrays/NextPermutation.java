package Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        int n = arr.length;
        int index1 = -1;
        int index2 = -1;

        for(int i=n-2; i>=0; i--)
        {
            if(arr[i] < arr[i+1])
            {
                index1 = i;
                break;
            }
        }

        if(index1 == -1)
        {
            reverse(arr,0);
        }

        for(int i=n-1; i>=0; i--)
        {
            if(arr[i] > arr[index1])
            {
                index2 = i;
                break;
            }
        }

        swap(arr,index1,index2);
        reverse(arr,index1+1);

    }

    void swap(int [] arr,int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void reverse(int [] arr, int start)
    {
        int i = start;
        int j = arr.length-1;
        while(i < j)
        {
            swap(arr,i,j);
            i++;
            j--;
        }
    }
}
