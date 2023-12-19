package project.menu;


import java.io.*;
import java.util.ArrayList;


public class Menu {

    private ArrayList<Dish> menus;
    public Menu() {
        this.menus = new ArrayList<>();
    }


    public void addItem(String restaurantName, String dishName, Double price) {

        Dish dish = new Dish(restaurantName, dishName, price);
        menus.add(dish);
        }

    public  void readMenuDataFile()
    {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("menus.txt")))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null) //reads each line until there is none
            {
                String[] itemData = line.split(",");
                String restaurantName = itemData[0];
                String dishName = itemData[1];
                double price = Double.parseDouble(itemData[2]);
                addItem(restaurantName, dishName, price);
            }
        }catch(IOException exp)
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


