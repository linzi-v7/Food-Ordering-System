package project.payment;

import java.util.Scanner;

public class Payment {
    private int transactionId;
    private String paymentStatus;
    private String paymentMethod;

    public Payment(int transactionId, String paymentStatus, String paymentMethod) {
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void paymentProcess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your preferred payment method:");
        System.out.println("(1) Cash on delivery");
        System.out.println("(2) Visa");
        System.out.println("(3) Digital wallet");
        System.out.println("------------------------------------------------------");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                cash();
                break;
            }
            case 2: {
                visa();
                break;
            }
            case 3: {
                wallet();
                break;
            }
            default: {
                System.out.println("Invalid choice");
            }
        }
    }

    private void cash() {
        System.out.println("Thanks for using our cash services.");
        setPaymentStatus("Paid");
        setPaymentMethod("Cash");
    }

    private void visa() {
        System.out.println("Enter your Visa details:");

        Scanner scanner = new Scanner(System.in);

        // Card number validation (length and digits only)
        long cardNumber = 0;
        while (true) {
            System.out.print("Enter the 16-digit Card Number (only digits allowed): ");
            String cardNumberStr = scanner.next();

            if (cardNumberStr.matches("^[0-9]{16}$")) {
                cardNumber = Long.parseLong(cardNumberStr);
                break; // Valid card number format
            } else {
                System.out.println("Invalid input. Please enter a 16-digit number.");
            }
        }

        scanner.nextLine(); // Consume the newline character

        // Cardholder name validation
        String cardHolderName;
        while (true) {
            System.out.print("Card Holder Name (letters and spaces only): ");
            cardHolderName = scanner.nextLine().trim(); // Handle spaces in name
            if (cardHolderName.matches("^[a-zA-Z ]+$")) {
                break; // Valid name format
            } else {
                System.out.println("Invalid name format. Please use letters and spaces only.");
            }
        }

        // CVV input with validation loop
        String cvv;
        while (true) {
            System.out.print("CVV (3 digits only): ");
            cvv = scanner.next();

            if (cvv.matches("^[0-9]{3}$")) {
                break; // Valid CVV format
            } else {
                System.out.println("Invalid CVV. Please enter a 3-digit number.");
            }
        }

        // Set payment status and method directly
        setPaymentStatus("Paid");
        setPaymentMethod("Visa");

        // ... (rest of your payment processing logic)

        System.out.println("Payment successful. Thank you!");
    }

    private void wallet() {
        System.out.println("Enter your wallet details:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wallet Owner: ");
        String walletOwner = scanner.next();

        // Wallet password validation
        String password;
        while (true) {
            System.out.print("Password (at least 8 characters with at least one capital letter and one number): ");
            password = scanner.next();

            if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*")) {
                break;  // Valid password format
            } else {
                System.out.println("Invalid password. Please meet the specified criteria.");
            }
        }

        // Implement actual logic to process wallet details securely

        // Set payment status and method directly
        setPaymentStatus("Paid");
        setPaymentMethod("Digital Wallet");

        System.out.println("Payment successful. Thank you!");
    }
}
