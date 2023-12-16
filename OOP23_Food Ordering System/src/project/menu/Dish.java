package project.menu;
import java.util.ArrayList;

public class Dish {
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

    public String toString() {
        return "name:'" + name + "description:" + description + "price$=" + price;
    }

    // Factory method to create MenuItem from a line in the file
    public static Dish fromString(String line) {
        String[] parts = line.split(",");
        String name = parts[0].trim();
        String description = parts[1].trim();
        double price = Double.parseDouble(parts[2].trim());
        return new Dish(name, description, price);
    }
}
/*class Menu {
    private ArrayList<Dishes> dish;
    public Menu() {
        this.dish = new ArrayList<>();
    }
    public void addDish(Dishes Dish) {
        dish.add(Dish);
    }
    public void displayMenu() {
        System.out.println("Menu:");
        for (Dishes Dish:dish ) {
            System.out.println(Dish);
        }
    }
}*/