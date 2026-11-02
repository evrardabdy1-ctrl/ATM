package Testlive;

import java.util.Scanner;

public class ATM {


    public static void main(String[] args) {

        Scanner inputY = new Scanner(System.in);

        int balance = 1000000;
        int[] transactions = new int[5];
        int historyIndex = 0;

        int totalDeposit = 0;
        int totalWithdrawn = 0;

        System.out.println("===== ATM SIMULATION =====");

        do {

            System.out.println("\nNavigation");
            System.out.println("1) Deposit");
            System.out.println("2) Withdrawal");
            System.out.println("3) Check Balance");
            System.out.println("4) Amount Deposited");
            System.out.println("5) Amount Withdrawn");
            System.out.println("6) Transactions History");
            System.out.println("0) Exit");

            System.out.print("\nSelect Menu: ");
            int menu = inputY.nextInt();

            if (menu == 0) {
                System.out.println("Thank you for using our ATM!");
                break;
            }

            // Check transaction capacity
            if ((menu == 1 || menu == 2) && historyIndex == transactions.length) {
                System.out.println("Transaction history is full!");
                continue;
            }

            // 1. DEPOSIT
            if (menu == 1) {

                System.out.print("Input amount: ");
                int amount = inputY.nextInt();

                if (amount <= 0) {
                    System.out.println("Invalid amount!");
                    continue;
                }

                balance += amount;
                totalDeposit += amount;

                transactions[historyIndex++] = amount;

                System.out.println("Deposit successful!");
                System.out.println("New Balance: " + balance);

            }

            // 2. WITHDRAWAL
            else if (menu == 2) {

                System.out.print("Input amount: ");
                int amount = inputY.nextInt();

                if (amount <= 0) {
                    System.out.println("Invalid amount!");
                    continue;
                }

                if (balance < amount) {
                    System.out.println("Insufficient balance!");
                    System.out.println("Your balance: " + balance);
                    continue;
                }

                balance -= amount;
                totalWithdrawn += amount;

                transactions[historyIndex++] = -amount;

                System.out.println("Withdrawal successful!");
                System.out.println("New Balance: " + balance);

            }

            // 3. CHECK BALANCE
            else if (menu == 3) {

                System.out.println("Balance: " + balance);

            }

            // 4. TOTAL DEPOSIT
            else if (menu == 4) {

                System.out.println("Total Deposit: " + totalDeposit);

            }

            // 5. TOTAL WITHDRAWAL
            else if (menu == 5) {

                System.out.println("Total Withdrawn: " + totalWithdrawn);

            }

            // 6. TRANSACTION HISTORY
            else if (menu == 6) {

                System.out.println("\nTransaction History:");

                if (historyIndex == 0) {
                    System.out.println("No transactions yet!");
                }

                for (int i = 0; i < historyIndex; i++) {

                    if (transactions[i] > 0) {
                        System.out.println((i + 1) + ". Deposit: " + transactions[i]);
                    } else {
                        System.out.println((i + 1) + ". Withdrawal: " + Math.abs(transactions[i]));
                    }

                }

            }

            // INVALID MENU
            else {

                System.out.println("Invalid menu selection!");

            }

        } while (true);

        inputY.close();

    }
}


