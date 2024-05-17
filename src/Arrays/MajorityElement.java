package Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int [] arr = {2,2,3,2,3,1,2};
        int element = 0, count = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(count == 0)
            {
                element = arr[i];
                count++;
            }
            else if(element == arr[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }

        int cnt = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == element) cnt++;
        }
        if(cnt > arr.length/2)
            System.out.println(element);
        else
            System.out.println("-1");
    }
}
