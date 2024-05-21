package Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int [] arr = {1,8,6,2,5,4,8,3,7};
        int left = 0, right = arr.length-1;
        int length, breadth, max = 0;
        while(left < right)
        {
            length = Math.min(arr[left],arr[right]);
            breadth = right - left;
            int area = length * breadth;
            max = Math.max(max,area);
            if(arr[left] < arr[right]) left++;
            else right--;
        }
        System.out.println(max);
    }
}
