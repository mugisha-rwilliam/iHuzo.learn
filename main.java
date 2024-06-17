import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        final float MAX_INTEREST_RATE = 20.0f; // Maximum allowed interest rate
        int principal = 1000;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal < 1000 || principal > 1000000) {
                System.out.print("The principal should be more than 1,000 and not higher than 1,000,000. Please enter a valid number: ");
                continue;
            }
            else {
                if (principal > 1000 && principal < 1000000)
                break;
            }
        }

        // Input validation for annual interest rate
        float annualInterest = 10;
        while (true) {
            System.out.print("Annual Interest Rate (%): ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= MAX_INTEREST_RATE) {
                break;
            } else {
                System.out.println("Please enter a valid interest rate between 0 and " + MAX_INTEREST_RATE + "%.");
            }
        }
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        
        byte years = 5;
        
        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years >= 5 && years <= 30)
                break;
            System.out.println("Enter any number between 4 and 31: ");
        }
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}

