package project.cart;
import project.menu.Dish;
import java.util.ArrayList;
import java.util.List;

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
        for (Dish item : cart) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }
}

