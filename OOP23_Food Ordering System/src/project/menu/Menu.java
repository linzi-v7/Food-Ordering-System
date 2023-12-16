package project.menu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Dish> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    // Load menu items from file
    public void loadMenuFromFile(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                menuItems.add(Dish.fromString(line));
            }
        }
    }

    // Display the menu
    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuItems.size(); i++) {
            Dish item = menuItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - $" + item.getPrice());
        }
    }

    // Get a specific menu item
    public Dish getMenuItem(int index) {
        return menuItems.get(index);
    }

    // Get the number of menu items
    public int getMenuSize() {
        return menuItems.size();
    }
}