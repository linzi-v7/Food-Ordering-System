package project.menu;


import java.io.*;
import java.util.ArrayList;


class Menu {

    private ArrayList<String> menus;
    public Menu() {
        this.menus = new ArrayList<>();
    }


    public void addItem(String restaurantName, String dishName, String price) {

            String dish = restaurantName + "," +dishName+"," + price ;
            menus.add(dish);
        }

    public  void readMenuDataFile()
    {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("menus.txt")))
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
    
    public void writeMenuDataFile()
    {

        try (PrintWriter writer = new PrintWriter((new FileWriter("menus.txt")))) {
                for (String str:menus)
                {
                    writer.write(str + "\n");
                }

        } catch (IOException exp) {
                System.out.println(exp.getMessage());
        }

    }
    
    public void displayMenu(String restaurantName)
    {
        for (String str : menus)
        {
            if(str != null) {
                String[] itemData = str.split(",");
                String restaurantNameInArr = itemData[0];
                String itemName = itemData[1];
                String itemPrice = itemData[2];
                if (restaurantName.equals(restaurantNameInArr)) {
                    System.out.println(itemName + ": " + itemPrice + "$");
                }
            }
        }
    }

    }
