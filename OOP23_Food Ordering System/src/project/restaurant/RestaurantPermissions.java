package project.restaurant;


import project.menu.Dish;
import project.order.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.random.*;

public interface RestaurantPermissions
{
    default void addDishToMenu(Dish dish)
    {
        try (PrintWriter writer = new PrintWriter((new FileWriter("menus.txt")))) {
                writer.write(dish.getRestaurantName() + "," + dish.getDishName()
                        + "," + dish.getPrice() + "\n");
        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        }    }

    default void removeDishFromMenu(Restaurant restaurant)
    {
        // restuarant.menu.removeDish();
    }

    default void viewOrders()
    {
    }

    default void updateDishPrice(Restaurant restaurant)
    {
        //restaurant.menu.updateDish();
    }

    //view profit,etc...
    default void generateBusinessReport(Restaurant restaurant)
    {
        Random rand = new Random();
        System.out.println("\t\t#### BUSINESS REPORT ####");
        System.out.println("Business Report For " + restaurant.getRestaurantName());
        System.out.println("Users served: " + rand.nextInt(5000));
        System.out.println("Revenue for the day: " + rand.nextInt(10000) + "$");
        System.out.println("Restaurant Performance: GREAT");
    }

}
