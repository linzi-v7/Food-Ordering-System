package project.menu;

import project.restaurant.Restaurant;

import java.io.*;
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
    public static Dish fromString(String line) {
        String[] parts = line.split(",");
        String name = parts[0].trim();
        String description = parts[1].trim();
        double price = Double.parseDouble(parts[2].trim());
        return new Dish(name, description, price);
      }
    }



class Menu {
    public Restaurant restaurant = new Restaurant();
    private ArrayList<Dish> dishes;
    public Menu() {
        this.dishes = new ArrayList<>();
    }
    public void loadMenuFromFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("menu.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                dishes.add(Dish.fromString(line));
            }
        }
    }

    public void addDish(Dish Dish) {


            dishes.add(Dish);
        }

        public void displayMenu() {
            System.out.println("Menu:");
            for (project.menu.Dish Dish : dishes) {
                System.out.println(Dish);
            }
        }

        public void writeMenuToFile()
        {
            try (PrintWriter writer = new PrintWriter((new FileWriter("menu.txt", true)))) {

                writer.write(restaurant.restaurantName);
                for (int i = 0; i < dishes.size(); i++) {
                    writer.write("," + dishes.get(i) + "," + dishes.get(i));
                }
                writer.write("\n");

            } catch (IOException exp) {
                System.out.println(exp.getMessage());
            }
        }
    }
