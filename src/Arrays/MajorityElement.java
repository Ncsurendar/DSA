package Arrays;

public class MajorityElement {

                                                        // Moore’s Voting Algorithm
  
    //Initialize 2 variables:
    //Count –  for tracking the count of element
    //Element – for which element we are counting
    //Traverse through the given array
    //If Count is 0 then store the current element of the array as Element.
    //If the current element and Element are the same increase the Count by 1.
    //If they are different decrease the Count by 1.
    //The integer present in Element should be the result we are expecting 
    
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
