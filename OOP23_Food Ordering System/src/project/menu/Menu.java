package project.menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
import java.util.Objects;


public class Menu {

    public ArrayList<Dish> newDishes;
    private ArrayList<Dish> restaurantMenu;
    private ArrayList<Dish> allMenus;

    public Menu() {
        this.restaurantMenu = new ArrayList<>();
        this.newDishes = new ArrayList<>();
        this.allMenus = new ArrayList<>();
        readMenuDataFile();
    }

    public void addItem(String restaurantName, String dishName, Double price) {
        Dish dishToAdd = new Dish(restaurantName, dishName, price);
        boolean found = false;

        for (Dish dish : restaurantMenu) {
            if (dishToAdd.equals(dish)) {
                found = true;
                break;
            }
        }

        if (!found) {
            restaurantMenu.add(dishToAdd);
        }
    }

    public void addNewDish(String restaurantName, String dishName, Double price) {
        Dish dishToAdd = new Dish(restaurantName, dishName, price);
        boolean found = false;
        for (Dish dish : allMenus) {
            if (dishToAdd.equals(dish)) {
                found = true;
                break;
            }
        }

        if (!found) {
            newDishes.add(dishToAdd);
        } else {
            System.out.println("DISH ALREADY EXISTS!");
        }
    }

    public void readMenuDataFile(String rName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("menus.txt"))) {
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
        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        }
    }

    public void readMenuDataFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("menus.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) //reads each line until there is none
            {
                String[] itemData = line.split(",");
                String restaurantName = itemData[0];
                String dishName = itemData[1];
                double price = Double.parseDouble(itemData[2]);
                Dish dish = new Dish(restaurantName, dishName, price);
                allMenus.add(dish);

            }
        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        }
    }

    public void writeMenuDataFile() {
        try (PrintWriter writer = new PrintWriter((new FileWriter("menus.txt", true)))) {
            if (!newDishes.isEmpty()) {
                for (Dish dish : newDishes) {
                    writer.write(dish.getRestaurantName() + "," + dish.getDishName() + "," + dish.getPrice() + "\n");
                }
            }
        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        }
    }

    public void displayMenu(String restaurantName) {
        for (Dish dish : restaurantMenu) {
            if (dish.getRestaurantName().equals(restaurantName)) {
                System.out.println(restaurantMenu.indexOf(dish)+1 + ". " + dish.getDishName() + ": $" + dish.getPrice());
            }
        }
    }


    // Get a specific menu item
    public Dish getMenuItem(int index) {
        return restaurantMenu.get(index);
    }

    // Get the number of menu items
    public int getMenuSize() {
        return restaurantMenu.size();
    }
}