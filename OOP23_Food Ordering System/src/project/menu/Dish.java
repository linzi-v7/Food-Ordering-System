package project.menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
class Dish {
    private String name;
    private String description;
    private double price;

    public Dish(String name, String description, double price)
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
    public static Dish fromString(String line) {
        String[] parts = line.split(",");
        String name = parts[0].trim();
        String description = parts[1].trim();
        double price = Double.parseDouble(parts[2].trim());
        return new Dish(name, description, price);
      }
    }
class Menu {
    private ArrayList<Dish> dish;
    public Menu() {
        this.dish = new ArrayList<>();
    }
    public void loadMenuFromFile(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                dish.add(Dish.fromString(line));
            }
        }
    }

    public void addDish(Dish Dish) {


            dish.add(Dish);
        }
        public void displayMenu() {
            System.out.println("Menu:");
            for (project.menu.Dish Dish : dish) {
                System.out.println(Dish);
            }
        }
    }
