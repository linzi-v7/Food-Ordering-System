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


    @Override
    public boolean equals(Object obj) {
        Dish otherDish = (Dish) obj;
        boolean equalName = (this.restaurantName.equals(otherDish.restaurantName));
        boolean equalItem = (this.dishName.equals(otherDish.dishName));
        boolean equalPrice = (this.price == otherDish.price);

        return equalName && equalItem && equalPrice;
    }
}