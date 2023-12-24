package project.order;

import project.cart.cart;
import project.user.User;

import java.util.Scanner;
import java.io.*;

public class Order {
    Scanner scanner = new Scanner(System.in);
        public void orderManagement(cart orderCart, User loggedInUser) {
            System.out.println("\n------------------------------------------------------\n");
            System.out.println("Please enter delivery time:- ");
            int time = scanner.nextInt();
            System.out.println("To confirm the order press Y");
            System.out.println("To cancel the order press C");
            char con;
            while (true) {
                con = scanner.next().charAt(0);
                if (con == 'Y' || con == 'y' || con == 'c' || con == 'C')
                    break;
                System.out.println("Invalid");
                System.out.println("To confirm the order press Y");
                System.out.println("To cancel the order press C");
            }
            if (con == 'Y' || con == 'y') {
                System.out.println("would you like to change your address?(y/n)");
                char ans = scanner.next().charAt(0);
                if (ans == 'y'){
                    System.out.print("enter your new address: ");
                    String newAddress = scanner.next();
                    System.out.println("Your Order : ");
                    orderCart.displayCart();
                    System.out.printf("Total Price: %.2f", orderCart.calculateTotal());
                    System.out.println("\nYour Address : " + newAddress + ".");
                }else {
                    System.out.println("Your Order : ");
                    orderCart.displayCart();
                    System.out.printf("Total Price: %.2f", orderCart.calculateTotal());
                    System.out.println("Your Address : " + loggedInUser.getAddress() + ".");
                }
            }
            if (con == 'c' || con == 'C'){
                System.out.println("order canceled");
                System.exit(-1);
            }
        }

    void saveOrder(cart cart, User user) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("orders.txt", true))) {
            writer.println("total w/o tax and delivery" + cart.calculateTotal());
            writer.println("Name: " + user.getName());
            writer.println("----------");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving order.");
        }
    }

    public void viewOrders() {
        try (Scanner scanner = new Scanner(new File("orders.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("----------")) {
                    System.out.println();
                } else {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error viewing orders.");
        }
    }
}

