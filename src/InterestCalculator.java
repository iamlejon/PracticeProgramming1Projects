import java.util.Scanner;

public class InterestCalculator {

    static int numOfYears;
    static double initialPrincipal;
    static double finalPrincipal;
    static double interestRate;
    static int choice;
    static double yearlyInterest;
    static double principalAtBeginningOfYear;

    private static void compoundInterest(int yearNumber) {

        //Choice 1 is Quarterly interest
        if(choice == 1) {
           finalPrincipal = initialPrincipal * Math.pow((1 + interestRate/4), 4*yearNumber);
        }
        //Choice 2 is Monthly Interest
        else if(choice == 2) {
            finalPrincipal = initialPrincipal * Math.pow((1 + interestRate / 12), 12 * yearNumber);
        }
        //Choice 3 is Yearly Interest
        else if(choice == 3) {
            finalPrincipal = initialPrincipal * Math.pow((1 + interestRate), yearNumber);
        }
    }

    public static void main(String[] args) {

        //Scanner items to take user console input.
        Scanner sc = new Scanner(System.in);
        Scanner principal = new Scanner(System.in);
        Scanner interest = new Scanner(System.in);
        Scanner years = new Scanner(System.in);

        System.out.println("Interest calculator. Choose Duration:");
        System.out.println("Type 1 for Quarterly");
        System.out.println("Type 2 for Monthly");
        System.out.println("Type 3 for Annually");

        choice = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the initial principal");
        initialPrincipal = Double.parseDouble(principal.nextLine());

        System.out.println("Enter the interest rate");
        interestRate = Double.parseDouble(interest.nextLine()) / 100;

        System.out.println("How many years will this be compounded?");
        numOfYears = Integer.parseInt(years.nextLine());


        //For loop.  Starting at year 1 this loop will print out the compound interest until we reach the specified end year given earlier.
        for(int i = 1; i<=numOfYears; i++) {
            //i represents the year number (year 1, year 2, etc)
            //Calling the compound interest method. We are passing in i for the year number.  This number will then be used in our formula to calculate compound interest.
            compoundInterest(i);

            if(i == 1) {
                principalAtBeginningOfYear = initialPrincipal;
            } else {
                principalAtBeginningOfYear = finalPrincipal -  yearlyInterest;
            }

            yearlyInterest = finalPrincipal - principalAtBeginningOfYear;

            System.out.println("------------------------------------------------------------------");
            System.out.println("The year number: " + i);
            System.out.println("The principal at the beginning of the year is: " + principalAtBeginningOfYear);
            System.out.println("The total amount of interest earned for the year is: " + yearlyInterest);
            System.out.println("Final principal is: " + finalPrincipal);
            System.out.println("------------------------------------------------------------------");
        }
    }
}
