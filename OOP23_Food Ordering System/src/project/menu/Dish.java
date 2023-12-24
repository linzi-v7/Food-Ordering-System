package project.menu;

public class Dish {
    private String restaurantName;
    private String dishName;
    private double price;

    public Dish(String restaurantName, String dishName, double price) {
        this.restaurantName = restaurantName;
        this.dishName = dishName;
        this.price = price;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getDishName() {
        return dishName;
    }

    public double getPrice() {
        return price;
    }

    // Factory method to create MenuItem from a line in the file
    /*public static Dish fromString(String line) {
        String[] parts = line.split(",");
        String restaurantName = parts[0];
        String dishName = parts[1];
        double price = Double.parseDouble(parts[2]);
        return new Dish(restaurantName, dishName, price);
    }*/

    @Override
    public boolean equals(Object obj) {
        Dish otherDish = (Dish) obj;
        boolean equalName = (this.restaurantName.equals(otherDish.restaurantName));
        boolean equalItem = (this.dishName.equals(otherDish.dishName));
        boolean equalPrice = (this.price == otherDish.price);

        return equalName && equalItem && equalPrice;
    }
}