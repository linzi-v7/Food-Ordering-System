package project.admin;

import project.restaurant.Restaurant;
import project.restaurant.RestaurantPermissions;
import project.user.User;

public interface AdminPermissions extends RestaurantPermissions
{
    default void addUser(String name, String email, String password, String address)
    {

    }

    default void removeUser(User user)
    {

    }

    default void addRestaurant(String name, String email, String password, String address)
    {

    }

    default void removeRestaurant(Restaurant restaurant)
    {

    }
}
