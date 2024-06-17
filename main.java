import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        final float MAX_INTEREST_RATE = 20.0f; // Maximum allowed interest rate

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        float principal = scanner.nextFloat();

        // Input validation for annual interest rate
        float annualInterest;
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

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}

