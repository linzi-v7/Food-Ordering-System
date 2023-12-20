package project.menu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
import java.util.Objects;


public class Menu {

    private ArrayList<Dish> menus;
    public Menu() {
        this.menus = new ArrayList<>();
    }
    public void addItem(String restaurantName, String dishName, Double price) {
        Dish dish = new Dish(restaurantName, dishName, price);
        menus.add(dish);
    }

    public  void readMenuDataFile(String rName)
    {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("menus.txt")))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null) //reads each line until there is none
            {
                String[] itemData = line.split(",");
                if (Objects.equals(rName, itemData[0])) {
                    String restaurantName = itemData[0];
                    String dishName = itemData[1];
                    double price = Double.parseDouble(itemData[2]);
                    addItem(restaurantName, dishName, price);
                }
            }
        }
        catch(IOException exp)
        {
            System.out.println(exp.getMessage());
        }
    }
    
    public void writeMenuDataFile()
    {
        try (PrintWriter writer = new PrintWriter((new FileWriter("menus.txt")))) {
            for (Dish dish : menus) {
                writer.write(dish.getRestaurantName() + "," + dish.getDishName() + "," + dish.getPrice() + "\n");
            }
        } catch (IOException exp) {
                System.out.println(exp.getMessage());
        }
    }
    
    public void displayMenu(String restaurantName)
    {
        for (Dish dish : menus)
        {
            if (dish.getRestaurantName().equals(restaurantName)) {
                System.out.println(dish.getDishName() + ": $" + dish.getPrice());
            }
        }
    }


    // Get a specific menu item
    public Dish getMenuItem(int index) {
        return menus.get(index);
    }

    // Get the number of menu items
    public int getMenuSize() {
        return menus.size();
    }
}


/*    private ArrayList<Dish> menuItems;

    public Menu() {this.menuItems = new ArrayList<>();}

    // Load menu items from file
    public  void loadMenuFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Nader\\Documents\\GitHub\\Food-Ordering-System\\OOP23_Food Ordering System\\menus.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) //reads each line until there is none
            {
                menuItems.add(Dish.fromString(line));
            }
        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        }
    }


    // Display the menu
    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuItems.size(); i++) {
            Dish item = menuItems.get(i);
            System.out.println((i + 1) + ". " + item.getDishName() + " - $" + item.getPrice());
        }
    }

    public void addItem(String restaurantName, String dishName, Double price) {
        Dish dish = new Dish(restaurantName, dishName, price);
        menuItems.add(dish);
    }

    public void writeMenuDataFile()
    {
        try (PrintWriter writer = new PrintWriter((new FileWriter("menus.txt")))) {
            for (Dish dish : menuItems) {
                writer.write(dish.getRestaurantName() + "," + dish.getDishName() + "," + dish.getPrice() + "\n");
            }
        } catch (IOException exp) {
            System.out.println(exp.getMessage());
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
}*/