package Arrays;

import java.util.HashSet;
public class RemoveDuplicates {
    
    // We have to think of a data structure that does not store duplicate elements. So can we use a Hash set. As we know HashSet only stores unique elements.
    static int removeDuplicate(int [] arr)
    {
        HashSet <Integer> set = new HashSet<>();              // Declare a HashSet
        for(int i=0; i<arr.length; i++)                       //  Run a for loop from starting to the end. Put every element of the array in the set.
        {
            set.add(arr[i]);
        }
        int k = set.size();
        int j=0;
        for(int x:set)
        {
            arr[j++] = x;                                     // Now put all elements of the set in the array from the starting of the array.
        }
        return k;                                             // Time complexity: O(n*log(n))+O(n), Space Complexity: O(n) 
    }

    public static void main(String[] args) {
        int [] arr = {1,1,2,2,2,3,3};
        int k = removeDuplicate2(arr);
        for(int i=0; i<k; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

    static int removeDuplicate2(int [] arr)
    {
        int i=0;
        for(int j=1; j<arr.length; j++)                    // We can think of using two pointers ‘i’ and ‘j’, we move ‘j’ till we don't get a number arr[j] which is different from arr[i].  
        {                                                  // As we got a unique number we will increase the i pointer and update its value by arr[j].
            if(arr[i] != arr[j])
            {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;                                      // Time Complexity: O(N), Space Complexity: O(1)
    }
}
