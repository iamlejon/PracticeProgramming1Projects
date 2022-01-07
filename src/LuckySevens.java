import java.util.Random;
import java.util.Scanner;

public class LuckySevens {

    static double balance;
    static int dice1;
    static int dice2;
    static int minimum = 1;
    static int maximum = 6;
    static int rollCounter = 0;
    static double highestBalance;
    static int highestBalanceRoll;

    private static void rollDice() {
        Random rand = new Random();
        dice1 = minimum + rand.nextInt((maximum - minimum) + 1);
        dice2 = minimum + rand.nextInt((maximum - minimum) + 1);
    }

    public static void main(String[] args) {
        Scanner dollars = new Scanner(System.in);

        System.out.println("How many dollars to you have to bet?");
        balance = Double.parseDouble(dollars.nextLine());
        highestBalance = 0;

        //Rolls dice until balance is 0 or less.  If user rolls a 7 adds 4 dollars to balance. Else lose 1 dollar.
        while(balance > 0) {
            rollDice();
            rollCounter ++;

            //If the sum of the dice equals 7, we add 4 dollars to balance
            if((dice1+dice2) == 7) {
                balance += 4;
            }
            //If the sum of the dice is not equal to 7, we subtract 1 dollar
            else {
                balance -= 1;
            }

            //If this is the first roll, the highestBalance && highest Balance roll number is automatically the beginning balance and first roll number.
            if(rollCounter == 1) {
               highestBalance = balance;
               highestBalanceRoll = rollCounter;
            }
            //If the new balance is ever higher than the highest recorded balance, we will set that balance to the new high, and set that roll number to the highest recorded roll.
            else if(balance > highestBalance) {
                highestBalance = balance;
                highestBalanceRoll = rollCounter;
            }
        }

        System.out.println("You are broke after " + rollCounter + " rolls");
        System.out.println("You should have quit after " + highestBalanceRoll + " rolls when you had $" + highestBalance);
    }
}
