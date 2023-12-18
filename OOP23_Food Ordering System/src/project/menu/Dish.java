package project.menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
class Dishes {
    private String name;
    private String description;
    private double price;

    public Dishes(String name, String description, double price)
        {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public String getName() {

        return name;
    }

    public String getDescription() {

        return description;
    }

    public double getPrice() {

        return price;
    }
    //@override
    public String toString() {
        return "name:'" + name + "description:" + description + "price$=" + price ;
                }
    public static Dishes fromString(String line) {
        String[] parts = line.split(",");
        String name = parts[0].trim();
        String description = parts[1].trim();
        double price = Double.parseDouble(parts[2].trim());
        return new Dishes(name, description, price);
      }
    }
class Menu {
    private ArrayList<Dishes> dish;
    public Menu() {
        this.dish = new ArrayList<>();
    }
    public void loadMenuFromFile(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                dish.add(Dishes.fromString(line));
            }
        }
    }

    public void addDish(Dishes Dish) {


            dish.add(Dish);
        }
        public void displayMenu() {
            System.out.println("Menu:");
            for (Dishes Dish : dish) {
                System.out.println(Dish);
            }
        }
    }
