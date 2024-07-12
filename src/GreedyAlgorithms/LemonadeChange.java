package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class LemonadeChange {

    public static boolean lemonadeChange(List<Integer> bills)
    {
        int five = 0, ten = 0;
        for (Integer bill : bills) {
            if (bill == 5) five += 1;
            else if (bill == 10) {
                if (five > 0) {
                    five -= 1;
                    ten += 1;
                } else return false;
            } else {
                if (five > 0 && ten > 0) {
                    five -= 1;
                    ten -= 1;
                } else if (five > 3) {
                    five -= 3;
                } else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> bills = new ArrayList<>();
        bills.add(5);
        bills.add(5);
        bills.add(5);
        bills.add(10);
        bills.add(20);

        System.out.print("Queues of customers: ");
        for(int bill : bills){
            System.out.print(bill + " ");
        }
        System.out.println();

        boolean ans = lemonadeChange(bills);
        if(ans)
            System.out.println("It is possible to provide change for all customers.");
        else
            System.out.println("It is not possible to provide change for all customers.");
    }
}
