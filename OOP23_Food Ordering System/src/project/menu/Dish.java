package project.menu;

import java.util.ArrayList;
class Dishes {
    private String name;
    private String description;
    private double price;
    private String additionalOption;

    public Dishes(String name, String description, double price, String additionalOption)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.additionalOption= additionalOption;
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

    public String getAdditionalOption() {

        return additionalOption;
    }
    public String toString() {
        return "name:'" + name + "description:" + description + "price$=" + price + "additionalOption:" + additionalOption;
    }
}
class Menu {
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
}