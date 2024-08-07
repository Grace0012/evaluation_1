import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String correctUserName = "user";
        String correctPassword = "1234";
        int numOfAttempts = 4;

        System.out.print("Enter a task (start, quit): ");
        String task = scanner.nextLine();

        if (task.equals("start")) {
            while (numOfAttempts > 0) {
                System.out.print("Enter your Username: ");
                String enteredUsername = scanner.nextLine();
                System.out.print("Enter your Password: ");
                String enteredPassword = scanner.nextLine();

                if (enteredUsername.equals(correctUserName) && enteredPassword.equals(correctPassword)) {
                    System.out.println("Username and password is right");

                    int totalSumOfItems = 0;
                    System.out.print("Enter number of items: ");
                    int noOfItems = scanner.nextInt();

                    ArrayList<Integer> ItemsPrice = new ArrayList<>();
                    

                    for (int i = 0; i < noOfItems; i++) {
                        System.out.print("Enter price of Item " + (i + 1) + ": ");
                        ItemsPrice.add(scanner.nextInt());
                        totalSumOfItems = ItemsPrice.get(i);
                    }

                    int vatPercentage = 0;
                    System.out.print("Is VAT charged (Y/N): ");
                    String isVat = scanner.next().trim().toLowerCase();

                    if (isVat.equals("y")) {
                        vatPercentage = 13;
                    }

                    int discountPercentage = 0;
                    System.out.print("Input a discount percentage : ");
                    discountPercentage = scanner.nextInt();

                    double totalWithVAT = totalSumOfItems * (1 + vatPercentage / 100.0);
                    double totalWithDiscountAndVat = totalWithVAT * (1 - discountPercentage / 100.0);

                    
                    long roundedTotal = Math.round(totalWithDiscountAndVat);

                
                    System.out.print("Enter Amount of money paid: ");
                    int paidAmount = scanner.nextInt();

                    int returnAmount = (int) (paidAmount - roundedTotal);
                    if (returnAmount >= 0) {
                        System.out.println("Change returned: " + returnAmount);
                        if (returnAmount > 0) {
                            if (returnAmount >= 1000) {
                                System.out.println("1000 - " + returnAmount / 1000);
                                returnAmount %= 1000;
                            }
                            if (returnAmount >= 500) {
                                System.out.println("500 - " + returnAmount / 500);
                                returnAmount %= 500;
                            }
                            if (returnAmount >= 100) {
                                System.out.println("100 - " + returnAmount / 100);
                                returnAmount %= 100;
                            }
                            if (returnAmount >= 50) {
                                System.out.println("50 - " + returnAmount / 50);
                                returnAmount %= 50;
                            }
                            if (returnAmount >= 20) {
                                System.out.println("20 - " + returnAmount / 20);
                                returnAmount %= 20;
                            }
                            if (returnAmount >= 10) {
                                System.out.println("10 - " + returnAmount / 10);
                                returnAmount %= 10;
                            }
                            if (returnAmount >= 5) {
                                System.out.println("5 - " + returnAmount / 5);
                                returnAmount %= 5;
                            }
                            if (returnAmount > 0) {
                                System.out.println("Remaining change - " + returnAmount);
                            }
                        }
                    } else {
                        System.out.println("You don't have sufficent money.");
                    }
                    break;
                } else {
                    numOfAttempts--;
                    System.out.println("Incorrect Username or password.");
                }
            }

            if (numOfAttempts <= 0) {
                System.out.println("Access denied.");
            }
        } else if (task.equals("quit")) {
            System.out.println("Exiting the system.");
        } else {
            System.out.println("Invalid Input.");
        }

        scanner.close();
    }
}
