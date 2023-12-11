package project.order;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Order  {
    private String username;
    private List<String> items;
    private String status;

    public Order(String username) {
        this.username = username;
        this.items = new ArrayList<>();
        this.status = "Pending";
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void viewOrder() {
        System.out.println("Order Details for " + username);
        System.out.println("Status: " + status);
        System.out.println("Items:");

        for (String item : items) {
            System.out.println(item);
        }
    }



    public String getUsername() {
        return username;
    }

    public List<String> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }
}

interface OrderManagement {
    default void placeOrder(String username, List<String> items) {
        Order order = new Order(username);

        for (String item : items) {
            order.addItem(item);
        }


        saveOrder(order);

        System.out.println("Order placed successfully!");
    }

    default void saveOrder(Order order) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("orders.txt", true))) {
            writer.println("Username: " + order.getUsername());
            writer.println("Status: " + order.getStatus());
            writer.println("Items:");
            for (String item : order.getItems()) {
                writer.println(item);
            }
            writer.println("----------");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving order.");
        }
    }

    default void viewOrders() {
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
