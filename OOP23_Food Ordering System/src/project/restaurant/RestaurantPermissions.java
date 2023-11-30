package project.restaurant;

import project.menu.Dish;

public interface RestaurantPermissions
{
    default void addDishToMenu()
    {

    }

    default void removeDishFromMenu(Dish dish)
    {

    }

    default void viewOrders()
    {

    }

    default void updateDishPrice(Dish dish)
    {

    }

    //view profit,etc...
    default void generateBusinessReport(Restaurant restaurant)
    {

    }

}
