package project.menu;

public class Dish
{
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
}
