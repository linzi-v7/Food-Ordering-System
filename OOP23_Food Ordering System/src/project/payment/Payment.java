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
        System.out.println("Enter the amount of cash you want to pay:");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();

        if (amount > 0) {
            System.out.println("Thanks for using our cash services.");
            setPaymentStatus("Paid");
        } else {
            System.out.println("Invalid amount. Please enter a valid amount.");
        }
    }

    private void visa() {
        System.out.println("Enter your Visa details:");
        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.next();
        while (cardNumber.length() != 16) {
            System.out.print("Enter the 16-digit Card Number: ");
            cardNumber = scanner.next();
        }
        System.out.print("Card Holder Name: ");
        String cardHolderName = scanner.next();
        System.out.print("CVV: ");
        String cvv = scanner.next();
        while (cvv.length() != 3) {
            System.out.print("Enter the 3-digit CVV: ");
            cvv = scanner.next();
        }

        System.out.println("Payment successful. Thank you!");
        setPaymentStatus("Paid");
    }

    private void wallet() {
        System.out.println("Enter your wallet details:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wallet Owner: ");
        String walletOwner = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();

        // Implement actual logic to process wallet details securely

        System.out.println("Payment successful. Thank you!");
        setPaymentStatus("Paid");
    }

    public static void main(String[] args) {
        // Creating a Payment object with initial details
        Payment payment = new Payment(123456, "Pending", "");

        // Testing payment processing
        payment.paymentProcess();

        // Displaying the updated payment details
        System.out.println("Transaction ID: " + payment.getTransactionId());
        System.out.println("Payment Status: " + payment.getPaymentStatus());
        System.out.println("Payment Method: " + payment.getPaymentMethod());
    }
}