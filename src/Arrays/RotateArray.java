package Arrays;

public class RotateArray {

    static void reverse(int arr[], int start, int end)
    {
        while(start <= end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void leftRotate(int arr[], int n, int d)
    {
        d = d % n;
        reverse(arr,0,d-1);
        reverse(arr, d,n-1);
        reverse(arr,0,n-1);

    }

    public static void main(String[] args) {
        int n = 7;
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int d = 3;
        leftRotate(arr,n,d);
        System.out.println("After Rotation");
        for(int i=0; i<n; i++)
        {
            System.out.print(arr[i]+" ");
        }

    }
}
