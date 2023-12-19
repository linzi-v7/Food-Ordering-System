package project.menu;

import project.restaurant.Restaurant;

import java.io.*;
import java.util.ArrayList;
import java.util.SortedMap;


class Menu {

    private ArrayList<String> menus;
    public Menu() {
        this.menus = new ArrayList<>();
    }


    public void addItem(String restaurantName, String dishName, String price) {

            String dish = restaurantName + "," +dishName+"," + price + "\n";
            menus.add(dish);
        }

    public  void readRestaurantDataFile()
    {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("menu.txt")))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null) //reads each line until there is none
            {
                menus.add(line);
            }
        }catch(IOException exp)
        {
            System.out.println(exp.getMessage());
        }
    }
    
    public void writeRestaurantDataFile()
    {
        for (String str:menus) 
        {
            try (PrintWriter writer = new PrintWriter((new FileWriter("menus.txt", true)))) {

                writer.write(str + "\n");

            } catch (IOException exp) {
                System.out.println(exp.getMessage());
            }
        }
    }
    
    public void displayMenu(String restaurantName)
    {
        for (String str : menus)
        {
            String[] itemData = str.split(",");
            String restaurantNameInArr = itemData[0];
            String itemName = itemData[1];
            String itemPrice = itemData[2];
            if (restaurantName.equals(restaurantNameInArr))
            {
                System.out.println(itemName + ": " + itemPrice +"$");
            }
        }
    }

    }
