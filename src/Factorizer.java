import java.util.ArrayList;
import java.util.Scanner;

public class Factorizer {

    public static void main (String[] args) {

        int originalNumber;
        int numberInput;
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("What number would you like to factor?");
        numberInput = Integer.parseInt(sc.nextLine());

        System.out.println("The factors of " + numberInput + " are:");
        //Using a for loop to find number entered by user modulo of index (Starting number). If it's 0, it is a factor.
        // Also summing the numbers (except for the number itself) to be used later to find prime number status.
        for(int i = 1; i <= numberInput; i++) {
            if(numberInput % i == 0) {
                list.add(i);
                if(i != numberInput) {
                    sum += i;
                }
            }
        }

        System.out.println(list);

        //If the factors (except the original number) add up to the original number it is a perfect number
        if(sum == numberInput) {
            System.out.println(numberInput + " is a perfect number");
        }
        else {
            System.out.println(numberInput + " is not a perfect number");
        }

        //If there are only 2 factors of the original number, it is prime.
        if(numberInput > 0 && list.size() == 2) {
            System.out.println(numberInput + " is a prime number.");
        }
        else {
            System.out.println(numberInput + " is not a prime number.");

        }



    }
}
