package project.cart;

import project.menu.Dish;
import project.menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cart {
    private List<Dish> cart;

    // Constructor
    public cart() {
        this.cart = new ArrayList<>();
    }

    // Add item to the cart
    public void addItem(Dish item) {
        cart.add(item);
    }

    public static void addToCart(Scanner scanner, Menu menu, cart orderCart) {
        int choice2;
        System.out.print("Enter the item number to add to the cart (0 to finish): ");
        while ((choice2 = scanner.nextInt()) != 0) {
            if (choice2 > 0 && choice2 <= menu.getMenuSize()) {
                orderCart.addItem(menu.getMenuItem(choice2 - 1));
            } else {
                System.out.println("Invalid choice. Try again.");
            }
            System.out.print("Enter the item number to add to the cart (0 to finish): ");
        }
    }


    // Calculate total cost
    public double calculateTotal() {
        double total = 0.0;
        for (Dish item : cart) {
            total += item.getPrice();
        }
        return total;
    }

    // Display items in the cart
    public void displayCart() {
        System.out.println("Items in the cart:");
        for (int i = 0; i < getCartSize() ; i++) {
            System.out.println(i+1 + ". "  + cart.get(i).getDishName() + " - $" + cart.get(i).getPrice());
        }
    }

    /*public void displayCartA()
    {
        System.out.println("Items in the cart:");
        int count = 1;
        int sz = cart.size();
        for (int i = 1;i<sz;i++){
            if(cart.get(i).getDishName().compareTo(cart.get(i-1).getDishName()) == 0) {
                count++;
                d = cart.get(i);
            }
            else{
                System.out.println(count + " " +d.getDishName() + " - $" + count * d.getPrice());
                count = 1;
            }
        }
        if(count > 1){
            System.out.println(count + " " +d.getDishName() + " - $" + count * d.getPrice());
            count = 1;
        }
    }*/

    public int getCartSize() {
        return cart.size();
    }

    public void removeItem(Scanner scanner, cart orderCart) {
        int x;
        orderCart.displayCart();
        System.out.print("\nEnter the item number to remove from the cart (0 to finish): ");
        while ((x = scanner.nextInt()) != 0) {
            System.out.print("\n------------------------------------------------------\n");
            if (x > 0 && x < orderCart.getCartSize()) {
                cart.remove(x - 1);
            } else {
                System.out.println("Invalid choice. Try again.");
            }
            orderCart.displayCart();
            System.out.print("\nEnter the item number to remove from the cart (0 to finish): ");
        }
    }
}

