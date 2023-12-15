package project.restaurant;



public interface RestaurantPermissions
{
    default void addDishToMenu(Restaurant restaurant)
    {
       // restaurant.menu.addDish()
    }

    default void removeDishFromMenu(Restaurant restaurant)
    {
        // restuarant.menu.removeDish();
    }

    default void viewOrders()
    {
        //OrderManagement.viewOrders();
    }

    default void updateDishPrice(Restaurant restaurant)
    {
        //restaurant.menu.updateDish();
    }

    //view profit,etc...
    default void generateBusinessReport(Restaurant restaurant)
    {
        System.out.println("Business Report For " + restaurant.getRestaurantName());
        System.out.println("Users served: 500");
        System.out.println("Revenue for the day: 1000$");
        System.out.println("Restaurant Performance: GREAT");
    }

}
