import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userId, password;
        String input;
        System.out.print("Enter user ID: ");
        userId = scanner.nextLine();
        System.out.print("Enter password: ");
        password = scanner.nextLine();

        if (!userId.equals("user") || !password.equals("1234")) {
            System.out.println("Invalid login. Exiting...");
            return;
        }

        while (true) {
            System.out.println("Enter the number of items (or type 'quit' to exit): ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            int numOfItems;
            try {
                numOfItems = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number of items. Try again.");
                continue;
            }

            double total = 0.0;
            for (int i = 1; i <= numOfItems; i++) {
                System.out.print("Enter the price of item " + i + ": ");
                double price;
                try {
                    price = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price. Try again.");
                    i--; // Repeat the same item
                    continue;
                }
                total += price;
            }

            System.out.print("Charge VAT (yes/no)? ");
            String chargeVAT = scanner.nextLine();
            if (chargeVAT.equalsIgnoreCase("yes")) {
                total *= 1.13; // Add 13% VAT
            }

            System.out.print("Enter discount percentage: ");
            double discount;
            try {
                discount = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid discount percentage. No discount will be applied.");
                discount = 0;
            }
            total -= total * (discount / 100);

            System.out.println("Total amount to be paid: " + total);

            System.out.print("Enter payment amount: ");
            double payment;
            try {
                payment = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid payment amount. Try again.");
                continue;
            }

            double change = payment - total;
            if (change < 0) {
                System.out.println("Insufficient payment. Try again.");
                continue;
            }

            System.out.println("Change: " + change);

            double highestDenomination;
            if (change >= 100) {
                highestDenomination = 100;
            } else if (change >= 50) {
                highestDenomination = 50;
            } else if (change >= 20) {
                highestDenomination = 20;
            } else if (change >= 10) {
                highestDenomination = 10;
            } else if (change >= 5) {
                highestDenomination = 5;
            } else if (change >= 1) {
                highestDenomination = 1;
            } else if (change >= 0.25) {
                highestDenomination = 0.25;
            } else if (change >= 0.1) {
                highestDenomination = 0.1;
            } else if (change >= 0.05) {
                highestDenomination = 0.05;
            } else {
                highestDenomination = 0.01;
            }

            System.out.println("Highest denomination of change: " + highestDenomination);
        }

        System.out.println("Program terminated.");
        scanner.close();
    }
}
