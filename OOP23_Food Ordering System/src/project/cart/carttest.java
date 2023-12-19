package project.cart;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import project.menu.*;
import project.menu.Menu;

public class carttest
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create menu
        Menu menu = new Menu();
        System.out.println("Enter the restaurant");
        String restaurant = scanner.nextLine();
        // Load menu from file
        menu.readMenuDataFile(restaurant);


        // Sample food order
        cart order = new cart();

        // Display the menu
        menu.displayMenu(restaurant);

        // User interaction
        System.out.print("Enter the item number to add to the cart (0 to finish): ");
        int choice;
        while ((choice = scanner.nextInt()) != 0) {
            if (choice > 0 && choice <= menu.getMenuSize()) {
                order.addItem(menu.getMenuItem(choice - 1));
            } else {
                System.out.println("Invalid choice. Try again.");
            }
            System.out.print("Enter the item number to add to the cart (0 to finish): ");
        }

        // Display the order
        order.displayCart();
        System.out.println("Total: $" + order.calculateTotal());

        // Close the scanner
        scanner.close();
    }
}
